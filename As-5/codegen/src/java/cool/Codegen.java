package cool;

import java.io.*;
import java.util.*;
import cool.AST.*;

@SuppressWarnings("unchecked")

public class Codegen{

	public String abort = new String("@_ZN6Object5abort"), type_name = new String("@_ZN6Object9type_name")
	, copy = new String("@_ZN6Object4copy"), out_string = "@_ZN2IO10out_string", out_int = "@_ZN2IO7out_int"
	, in_string = "@_ZN2IO9in_string", in_int = "@_ZN2IO9in_int", io_copy = "@_ZN2IO4copy", int_copy = "@_ZN3Int4copy",
	bool_copy = "@_ZN4Bool4copy", string_length = "@_ZN6String6length", string_concat = "@_ZN6String6concat"
	, string_substr = "@_ZN6String6substr", string_copy = "@_ZN5String4copy", str_un_const = " = private unnamed_addr constant [",
	abort_obj = "define %classObject* @_ZN6Object5abort( %class.Object* %this ) noreturn {\nentry:\ncall void @exit( i32 1 )\nret %classObject* null\n}\n"
	, base_object = "define void @_Z6ObjectBaseC ( %class.Object.Base ) {\nentry:\nret void\n}\n"
	, string_concat_ = "define [1024 x i8]* @_ZN6String6concat( [1024 x i8]* %this, [1024 x i8]* %that ) {\nentry:\n%retval = call [1024 x i8]* @_ZN6String4copy( [1024 x i8]* %this )\n%0 = bitcast [1024 x i8]* %retval to i8*\n%1 = bitcast [1024 x i8]* %that to i8*\n%2 = call i8* @strcat( i8* %0, i8* %1 )\nret [1024 x i8]* %retval\n}\n"
	, string_length_ = "define i32 @_ZN6String6length( [1024 x i8]* %this ) {\nentry:\n%0 = bitcast [1024 x i8]* %this to i8*\n%1 = call i64 @strlen( i8* %0 )\n%retval = trunc i64 %1 to i32\nret i32 %retval\n}\n"
	, method_decls = "declare i32 @printf(i8*, ...)\ndeclare i32 @scanf(i8*, ...)\ndeclare i32 @strcmp(i8*, i8*)\ndeclare i8* @strcat(i8*, i8*)\ndeclare i8* @strcpy(i8*, i8*)\ndeclare i8* @strncpy(i8*, i8*, i32)\ndeclare i64 @strlen(i8*)\ndeclare i8* @malloc(i64)\ndeclare void @exit(i32)";

	class input_struct{
		String name, parent;
		HashMap<String, attr> al;
		HashMap<String, method> ml;
		HashMap<String, Integer> ao;
		HashMap <String, Integer> mo;
		HashMap <String, String> irn;
		List <attr> pa;
		List <method> pm;
		public input_struct(){
			name = new String(""); parent = new String("");
			al = new HashMap<>();
			ml = new HashMap<>();
			ao = new HashMap<>();
			mo = new HashMap<>();
			irn = new HashMap<>();
			pa = new ArrayList<>();
			pm = new ArrayList<>();
		}
	}

	class IRstruct{
		String name, parent_name;
		HashMap<String, formal> formal_list;
		HashMap<String, feature> feature_list;
		HashMap<String, attr> attr_map;
		ArrayList<attr> attr_list;
		HashMap<String, method> method_map;
		ArrayList<method> method_list;
		HashMap <String, Integer> attr_offset;
		HashMap <String, Integer> method_offset;
		HashMap <String, String> irname;

		public IRstruct(String nm, String pr, HashMap<String, attr> al
		, HashMap<String, method> ml, HashMap<String, Integer> ao
		, HashMap<String, Integer> mo, ArrayList<attr> pa, ArrayList<method> pm, HashMap<String, String> irn){
			name = nm; parent_name = pr;
			attr_map = new HashMap<>();
			method_map = new HashMap<>();
			attr_offset = new HashMap<>();
			irname = new HashMap <>();
			method_offset = new HashMap<>();
			formal_list = new HashMap<>();
			feature_list = new HashMap<>();
			attr_list = new ArrayList<>();
			method_list = new ArrayList<>();
			attr_map.putAll(al);
			method_map.putAll(ml);
			attr_offset.putAll(ao);
			irname.putAll(irn);
			method_offset.putAll(mo);
			attr_list.addAll(pa);
			method_list.addAll(pm);
		}
	}

	HashMap<String, IRstruct> class_list = new HashMap<>();
	HashMap<String, class_> name_class;
	HashMap<String, Integer> class_no;
	HashMap<Integer, String> no_class;
	HashMap<String, String> type_map;
	List<int []> edges;
	List<List<Integer>> matrix;
	List<feature> class_f;
	Queue<Integer> classes_;
	expression expr;
	int count = 0, register = 2;

	formal return_formal(String param1, String param2, int param3){
		return new formal(param1, param2, param3);
	}

	expression get_expr(){
		return new expression();
	}

	String return_constant(String param){
		String str = new String(" x i8] c\"" + param + "\\00\", align 1");
		return str;
	}

	void reset(){
		classes_.clear();
		classes_.offer(0);
	}

	void firstPass(class_ main, PrintWriter out){
		Iterator<feature> it = main.features.iterator();
		while(it.hasNext()){
			feature f = it.next();
			attr temp_attr;
			method temp_method;
			if(f instanceof method){
				temp_method = (method) f;
				get_expression(temp_method.body, out);
			}
			else if(f instanceof attr){
				temp_attr = (attr) f;
				get_expression(temp_attr.value, out);
			}
		}
	}

	void fillClasses(class_ curr_class){
		int length = curr_class.name.length();
		String parent_name = curr_class.parent;
		int attr_ptr = 1, method_ptr;
		HashMap<String, formal> formal_list = new HashMap<>();
		HashMap<String, method> tcmlist = new HashMap<>();
		HashMap<String, attr> tcalist = new HashMap<>();

		/*variables needed from the parent class, later insert them all in an IRstruct class and insert into the class_list*/
		HashMap<String, attr> parent_alist = new HashMap<>();
		parent_alist = class_list.get(parent_name).attr_map;

		HashMap<String, method> parent_mlist = new HashMap<>();
		parent_mlist = class_list.get(parent_name).method_map;

		HashMap<String, Integer> parent_methodoffset = new HashMap<>();
		parent_methodoffset = class_list.get(parent_name).method_offset;

		ArrayList<method> parent_method_list= new ArrayList<>();
		parent_method_list = class_list.get(parent_name).method_list;

		HashMap<String, String> parent_irname = new HashMap<>();
		parent_irname = class_list.get(parent_name).irname;
		/*******************************************************/

		/*newly populated hashmaps, to be inserted in the class*/
		HashMap<String, Integer> attr_offset = new HashMap<>();
		ArrayList<attr> attr_list = new ArrayList<>();
		/*******************************************************/

		attr_list.add(return_attr("__Base", parent_name + ".Base", 0));
	    attr_offset.put("__Base", 0);

		List<feature> flist = curr_class.features;
		Iterator<feature> it = flist.iterator();
		while(it.hasNext()){
			feature ft = it.next();
			if(ft instanceof method){
				method me = (method) ft;
	            tcmlist.put(me.name, me);
			}
			else if(ft instanceof attr){
				attr ae = (attr) ft;
	            tcalist.put(ae.name, ae);
	            attr_list.add(ae);
	            attr_offset.put(ae.name, attr_ptr++);
			}
		}

		parent_irname.put("copy", "@_ZN" + length + curr_class.name + "4copy");

		method_ptr = parent_method_list.size();

		Iterator<Map.Entry<String, method>> entries = tcmlist.entrySet().iterator();
		while(entries.hasNext()){
  			Map.Entry<String, method> thisEntry = entries.next();
  			String key = thisEntry.getKey();
  			method value = thisEntry.getValue();
			method presence = parent_mlist.get(key);
			if(presence == null){
				parent_method_list.add(value);
	            parent_methodoffset.put(key, method_ptr++);
	            parent_irname.put(key, "@_ZN" + length + curr_class.name + key.length() + key);
			}
			else{
				parent_method_list.set(parent_methodoffset.get(key), value);
	            parent_irname.put(key, "@_ZN" + length + curr_class.name + key.length() + key);
			}
		}
		IRstruct final_class = new IRstruct(curr_class.name, parent_name, parent_alist, parent_mlist, attr_offset
		, parent_methodoffset, attr_list, parent_method_list, parent_irname);
		class_list.put(curr_class.name, final_class);
	}

	void initialize(int size){
		matrix = new ArrayList<List<Integer>>(2 + size);
		matrix.add(new ArrayList<Integer>(Arrays.asList(1))); matrix.add(new ArrayList<Integer>());
	}

	method return_method(String param1, List<formal> param2, String param3, int param4){
		return new method(param1, param2, param3, new expression(), param4);
	}

	attr return_attr(String param1, String param2, int param3){
		return new attr(param1, param2, new expression(), param3);
	}

	void fillBasicClasses(){
		List<formal> obj_formal = new ArrayList<>();
		obj_formal.add(return_formal("this", "Object", 0));

		HashMap<String, method> ol = new HashMap<>();
		ol.put("type_name", return_method("type_name", obj_formal, "String", 0));
		ol.put("abort", return_method("abort", obj_formal, "Object", 0));

		ArrayList<method> obj_mlist = new ArrayList<>();
		obj_mlist.add(return_method("type_name", obj_formal, "String", 0));
		obj_mlist.add(return_method("abort", obj_formal, "Object", 0));
		obj_mlist.add(return_method("copy", obj_formal, "Object", 0));

		HashMap<String, Integer> obj_moffset = new HashMap<>();
		obj_moffset.put("abort", 0);
		obj_moffset.put("type_name", 1);
		obj_moffset.put("copy", 2);

		HashMap<String, String> irname = new HashMap<>();
		irname.put("abort", abort);
		irname.put("type_name", type_name);
		irname.put("copy", copy);

		class_list.put("Object", new IRstruct("Object", null, new HashMap<String, attr>(), ol
		, new HashMap<String, Integer>(), obj_moffset, new ArrayList <attr>(), obj_mlist, irname));

		/**********************************************************************/

		class_list.put("Int", new IRstruct("Int", "Object", new HashMap<String, attr>(), ol
		, new HashMap<String, Integer>(), obj_moffset, new ArrayList<attr>(), obj_mlist, irname));
		class_list.get("Int").method_list.get(2).typeid = "Int";
		class_list.get("Int").irname.put("copy", int_copy);

		/**********************************************************************/

		class_list.put("Bool", new IRstruct("Bool", "Object", new HashMap<String, attr>(), ol
		, new HashMap<String, Integer>(), obj_moffset, new ArrayList<attr>(), obj_mlist, irname));
		class_list.get("Int").method_list.get(2).typeid = "Bool";
		class_list.get("Bool").irname.put("copy", bool_copy);

		/**********************************************************************/

		HashMap<String, method> iol = new HashMap<>();
		List<formal> os_formals = new ArrayList<>();
		List<formal> io_formal = new ArrayList<>();
		List<formal> oi_formals = new ArrayList<>();
		io_formal.add(return_formal("this", "IO", 0));
		os_formals.addAll(io_formal);
		os_formals.add(return_formal("out_string", "String", 0));
		oi_formals.addAll(io_formal);
		oi_formals.add(return_formal("out_int", "Int", 0));

		iol.put("in_string", return_method("in_string", io_formal, "String", 0));
		iol.put("in_int", return_method("in_int", io_formal, "Int", 0));
		iol.put("out_string", return_method("out_string", os_formals, "IO", 0));
		iol.put("out_int", return_method("out_int", oi_formals, "IO", 0));

		HashMap<String, Integer> io_moffset = new HashMap<>();
		io_moffset.putAll(obj_moffset);
		io_moffset.put("in_string", 5);
		io_moffset.put("in_int", 6);
		io_moffset.put("out_string", 3);
		io_moffset.put("out_int", 4);

		ArrayList<method> io_mlist = new ArrayList<>();
		io_mlist.addAll(obj_mlist);
		io_mlist.add(return_method("in_string", io_formal, "String", 0));
		io_mlist.add(return_method("in_int", io_formal, "Int", 0));
		io_mlist.add(return_method("out_string", os_formals, "IO", 0));
		io_mlist.add(return_method("out_int", oi_formals, "IO", 0));

		//redefine copy
		io_mlist.set(2, return_method("copy", io_formal, "IO", 0));

		HashMap<String, String> io_irname = new HashMap<>();
		io_irname.putAll(irname);
		io_irname.put("copy", io_copy);
		io_irname.put("out_string", out_string);
		io_irname.put("out_int", out_int);
		io_irname.put("in_string", in_string);
		io_irname.put("in_int", in_int);
		iol.putAll(ol);

		class_list.put("IO", new IRstruct("IO", "Object", new HashMap<String, attr>(), iol, new HashMap<String, Integer>()
		, io_moffset, new ArrayList<attr>(), io_mlist, io_irname));
		class_list.get("IO").attr_list.add(return_attr("__Base", "Object.Base", 0));
		class_list.get("IO").attr_offset.put("__Base", 0);

		/**********************************************************************/

		HashMap<String, method> sl = new HashMap<>();
		List<formal> str_formal = new ArrayList<>();
		List<formal> concat_formal = new ArrayList<>();
		List<formal> substr_formal = new ArrayList<>();
		str_formal.add(return_formal("this", "String", 0));
		concat_formal.add(return_formal("this", "String", 0));
		concat_formal.add(return_formal("that", "String", 0));
		substr_formal.add(return_formal("this", "String", 0));
		substr_formal.add(return_formal("index", "Int", 0));
		substr_formal.add(return_formal("len", "Int", 0));

		sl.put("concat", return_method("concat", concat_formal, "String", 0));
		sl.put("substr", return_method("substr", substr_formal, "String", 0));
		sl.put("length", return_method("length", str_formal, "Int", 0));

		HashMap<String, Integer> str_moffset = new HashMap<>();
		str_moffset.putAll(obj_moffset);
		str_moffset.put("substr", 5);
		str_moffset.put("concat", 4);
		str_moffset.put("length", 3);

		ArrayList<method> str_mlist = new ArrayList<>();
		str_mlist.addAll(obj_mlist);
		str_mlist.add(return_method("substr", substr_formal, "String", 0));
		str_mlist.add(return_method("concat", concat_formal, "String", 0));
		str_mlist.add(return_method("length", str_formal, "Int", 0));
		str_mlist.set(2, return_method("copy", str_formal, "String", 0));
		//redefine copy
		str_mlist.get(2).typeid = "String";

		HashMap<String, String> str_irname = new HashMap<>();
		str_irname.putAll(irname);
		str_irname.put("length", string_length);
		str_irname.put("concat", string_concat);
		str_irname.put("substr", string_substr);
		str_irname.put("copy", string_copy);

		sl.putAll(ol);
		class_list.put("String", new IRstruct("String", "Object", new HashMap<String, attr>(), sl
		, new HashMap<String, Integer>(), str_moffset, new ArrayList<attr>(), str_mlist, str_irname));
	}

	void get_expression(expression expr, PrintWriter out){
		if(expr instanceof assign){
			get_expression(((assign) expr).e1, out);
		}
		else if(expr instanceof static_dispatch){
			Iterator<expression> it = ((static_dispatch) expr).actuals.iterator();
			while(it.hasNext()){
				expr = it.next();
				if(!(expr instanceof string_const)){
					get_expression(expr, out);
				}
				else{
					printer(expr, out);
					return;
				}
			}
		}
		else if(expr instanceof dispatch){
			Iterator<expression> it = ((dispatch) expr).actuals.iterator();
			while(it.hasNext()){
				expr = it.next();
				if(!(expr instanceof string_const)){
					get_expression(expr, out);
				}
				else{
					printer(expr, out);
					return;
				}
			}
		}
		else if(expr instanceof cond){
			List<expression> conds = new ArrayList<>();
			conds.add(((cond) expr).ifbody);
			conds.add(((cond) expr).predicate);
			conds.add(((cond) expr).elsebody);
			if(!(conds.get(0) instanceof string_const)){
				get_expression(conds.get(0), out);
			}
			else{
				printer(conds.get(0), out);
				return;
			}
			if(!(conds.get(1) instanceof string_const)){
				get_expression(conds.get(1), out);
			}
			else{
				printer(conds.get(1), out);
				return;
			}
			if(!(conds.get(2) instanceof string_const)){
				get_expression(conds.get(2), out);
			}
			else{
				printer(conds.get(2), out);
				return;
			}
		}
		else if(expr instanceof let){
			if(!(((let) expr).body instanceof string_const)){
				get_expression(((let) expr).body, out);
			}
			else{
				printer(((let) expr).body, out);
				return;
			}
			if(!(((let) expr).value instanceof string_const)){
				get_expression(((let) expr).value, out);
			}
			else{
				printer(((let) expr).value, out);
				return;
			}
		}
		else if(expr instanceof block){
			Iterator<expression> it = ((block) expr).l1.iterator();
			while(it.hasNext()){
				expression temp = it.next();
				if(!(temp instanceof string_const)){
					get_expression(temp, out);
				}
				else{
					printer((string_const) temp, out);
					return;
				}
			}
		}
		else if(expr instanceof loop){
			expression pred = ((loop) expr).predicate, body = ((loop) expr).body;
			if(!(body instanceof string_const)){
				get_expression(body, out);
			}
			else{
				printer((string_const) body, out);
				return;
			}
			if(!(pred instanceof string_const)){
				get_expression(pred, out);
			}
			else{
				printer((string_const) pred, out);
				return;
			}
		}
		else if(expr instanceof typcase){
			if(!(((typcase) expr).predicate instanceof string_const)){
				get_expression(((typcase) expr).predicate, out);
			}
			else{
				printer(((typcase) expr).predicate, out);
				return;
			}
			Iterator<branch> it = ((typcase) expr).branches.iterator();
			while(it.hasNext()){
				branch temp = it.next();
				branch branch_ = new AST.branch(temp.name, temp.type, temp.value, temp.lineNo);
				branch_ = temp;
				if(!(branch_.value instanceof string_const)){
					get_expression(branch_.value, out);
				}
				else{
					printer(branch_.value,out);
					return;
				}
			}
		}
		else if(expr instanceof eq){
			if(!(((eq) expr).e2 instanceof string_const)){
				get_expression(((eq) expr).e2, out);
			}
			else{
				printer(((eq) expr).e2, out);
				return;
			}
			if(!(((eq) expr).e1 instanceof string_const)){
				get_expression(((eq) expr).e1, out);
			}
			else{
				printer(((eq) expr).e1, out);
				return;
			}
		}
		else if(expr instanceof string_const){
			printer((string_const) expr, out);
		}
	}

	void printer(expression expr, PrintWriter out){
		string_const str_obj = (string_const) expr;
		String value = new String(str_obj.value);
		if(count != 0)
			out.println("@.str."+ count + str_un_const + (value.length() + 1) + return_constant(value));
		else
			out.println("@.str" + str_un_const + (value.length() + 1) + return_constant(value));
		++count;
	}

	String get_type(String typeid) {
		if(typeid.equals("Int")){
			return "i32";
		}
		else if(typeid.equals("Bool")){
			return "i32";
		}
		else if(typeid.equals("String")){
			return "[1024 x i8]*";
		}
		else{
			String default_str = new String("%class." + typeid + "*");
			return default_str;
		}
	}

	void printClass(IRstruct class_, String parent, PrintWriter out){
		String typeid, name = class_.name;
		boolean enter = false;
		String starting = new String("%class." + class_.name + ".Base = type {");
		out.print(starting);
		Iterator<attr> it = class_.attr_list.iterator();
		while(it.hasNext()){
			attr temp = it.next();
			if(enter) out.print(", ");
			enter = true;
			typeid = temp.typeid;
			out.print(get_type(typeid));
		}
		if(enter) out.println(" }");
		String end = new String("%class." + name + " = type { i32, i8*, %class." + name + ".Base }");
		out.println(end);
	}

	void printVirtualTable(IRstruct class_, String parent, PrintWriter out){
		boolean flag = false;
		String name = class_.name;
		String start = new String("@_ZTV" + name.length() + name + " = constant " + "[" + class_.method_list.size() + " x i8*] [");
		out.print(start);
		Iterator<method> it = class_.method_list.iterator();
		while(it.hasNext()){
			method m = it.next();
			if(flag) out.print(", ");
			out.print("i8* bitcast (" + get_type(m.typeid) + " ( ");
			Iterator<formal> ix = m.formals.iterator();
			boolean inner = false;
			while(ix.hasNext()){
				formal f = ix.next();
				if(inner) out.print(", ");
				out.print(get_type(f.typeid));
			}
			out.print(" )* " + class_.irname.get(m.name) + " to i8*)");
		}
		out.println("] ");
	}

	void printmethods(IRstruct class_, String parent, PrintWriter out){
		String name = class_.name;
		if(name.equals("Object")){
			out.print(abort_obj);
			out.print(base_object);
		}
		else if(name.equals("String")){
			out.print(string_length_);
			out.print(string_concat_);
		}
		else if(name.equals("Int")){
			return;
		}
		else if(name.equals("Bool")){
			return;
		}
		else{
			printDefault(class_, parent, out);
		}
	}

	public void loadCode(String lval, String rtype, String rval, int align, PrintWriter out){
   		out.println(lval + " = " + rtype + " " + rval + ", align " + align);
   	}

	void printDefault(IRstruct class_, String parent, PrintWriter out){
		int count = 0, i = 0;
		String name = class_.name, typeid;
		String start = new String("define void @_Z" + name.length() + name + "Base" + "C" + " ( %" + name + ".Base*" + "%this" + " ) { ");
		out.println(start);
		out.println("entry: ");
		Iterator<attr> it = class_.attr_list.iterator();
		while(it.hasNext()){
			attr at = it.next();
			typeid = at.typeid;
			String print = new String("%" + count + " = getelementptr inbouds %" + "class." + typeid + ".Base" + ", " + "class." + typeid + ".Base" + "* %this, i32 0, i32 " + i + "\n");
			print += new String("call void " + "@_Z" + typeid.length() + typeid + "Base"+ "C" + "( %" + "class." + typeid + ".Base" + "*" + "%" + i + "\n" + "return void");
			out.println(print);
			i++;
		}
	}

	String generate_statement_ir_code(expression expr, PrintWriter out){
		String base_start = new String("");
		if(expr instanceof no_expr){
			return "";
		}
		else if(expr instanceof bool_const){
			base_start = "%" + register;
			if(((bool_const) expr).value){
				loadCode(base_start, "i8", 1 + "", 1, out);
			}
			else{
				loadCode(base_start, "i8", 0 + "", 1, out);
			}
			++register;
			return base_start;
		}
		else if(expr instanceof int_const){
			base_start = "%" + register;
			loadCode(base_start, "i32", ((int_const) expr).value + "", 4, out);
            ++register;
            return base_start;
		}
		else if(expr instanceof plus){
			String l, r;
			base_start = "%" + register;
			++register;
			String ret1 = generate_statement_ir_code(((plus) expr).e1, out);
			String ret2 = generate_statement_ir_code(((plus) expr).e2, out);
			out.println(register + " = add nsw i32 " + ret1 + " , " + ret2);
			return base_start;
		}
		else if(expr instanceof sub){
			String l, r;
			base_start = "%" + register;
			++register;
			String ret1 = generate_statement_ir_code(((sub) expr).e1, out);
			String ret2 = generate_statement_ir_code(((sub) expr).e2, out);
			out.println(register + " = sub nsw i32 " + ret1 + " , " + ret2);
			return base_start;
		}
		else if(expr instanceof divide){
			String l, r;
			base_start = "%" + register;
			++register;
			String ret1 = generate_statement_ir_code(((divide) expr).e1, out);
			String ret2 = generate_statement_ir_code(((divide) expr).e2, out);
			out.println(register + " = sdiv nsw i32 " + ret1 + " , " + ret2);
			return base_start;
		}
		else if(expr instanceof mul){
			String l, r;
			base_start = "%" + register;
			++register;
			String ret1 = generate_statement_ir_code(((mul) expr).e1, out);
			String ret2 = generate_statement_ir_code(((mul) expr).e2, out);
			out.println(register + " = mul nsw i32 " + ret1 + " , " + ret2);
			return base_start;
		}
		else if(expr instanceof leq){
			String l, r;
 			base_start = "%" + register;
 			++register;
 			String ret1 = generate_statement_ir_code(((leq) expr).e1, out);
 			String ret2 = generate_statement_ir_code(((leq) expr).e2, out);
 			out.println(register + " = icmp sle i32 " + ret1 + " , " + ret2);
 			return base_start;
		}
		else if(expr instanceof lt){
			String l, r;
 			base_start = "%" + register;
 			++register;
 			String ret1 = generate_statement_ir_code(((lt) expr).e1, out);
 			String ret2 = generate_statement_ir_code(((lt) expr).e2, out);
 			out.println(register + " = icmp slt i32 " + ret1 + " , " + ret2);
 			return base_start;
		}
		return "_no_type";
	}

	public Codegen(AST.program program, PrintWriter out){
		//Write Code generator code here
		out.println("; I am a comment in LLVM-IR. Feel free to remove me.");
		out.println("target datalayout = \"e-m:e-i64:64-f80:128-n8:16:32:64-S128\"");
		out.println("target triple = \"x86_64-unknown-linux-gnu\"");
		out.println("@Abortdivby0 = private unnamed_addr constant [22 x i8] c\"Error: Division by 0\\0A\\00\", align 1\n@Abortdispvoid = private unnamed_addr constant [25 x i8] c\"Error: Dispatch on void\\0A\\00\", align 1");
		out.println(method_decls);

		fillBasicClasses();

		class_ startc;
		int start_node = 2;
		String parent_ = new String("");
		name_class = new HashMap<>();
		class_no = new HashMap<>();
		no_class = new HashMap<>();
		edges = new ArrayList<>();
		class_f = new ArrayList<>();
		classes_ = new ArrayDeque<>();
		type_map = new HashMap<>();
		no_class.put(0, "Object");
		no_class.put(1, "IO");
		initialize(program.classes.size());
		class_no.put("Object", 0);
		class_no.put("IO", 1);

		Iterator<class_> it = program.classes.iterator();
		while(it.hasNext()){
			class_ cl = it.next();
			class_no.put(cl.name, start_node);
			no_class.put(start_node, cl.name);
			name_class.put(cl.name, cl);
			matrix.add(new ArrayList<>());
			++start_node;
		}

		Iterator<class_> ix = program.classes.iterator();
		while(ix.hasNext()){
			class_ cl = ix.next();
			int start = class_no.get(cl.parent), end = class_no.get(cl.name);
			int [] t_ = {start, end};
			matrix.get(start).add(end);
			edges.add(t_);
		}

		boolean [] visited = new boolean[program.classes.size() + 2];
		Arrays.fill(visited, false);
		for(int i = 0;i < program.classes.size() + 2;i++){
			if(visited[i]){
				continue;
			}
			classes_.offer(i);
			visited[i] = true;
			while(!classes_.isEmpty()){
				int get = classes_.poll();
				try{
					if(!no_class.get(get).equals("IO") && !no_class.get(get).equals("Object")){
						fillClasses(name_class.get(no_class.get(get)));
					}
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				printClass(class_list.get(no_class.get(get)), parent_, out);
				for(int [] edge : edges){
					if(get == edge[0] && visited[edge[1]] == false){
						classes_.offer(edge[1]);
						visited[edge[1]] = true;
					}
				}
			}
		}

		reset();
		while(!classes_.isEmpty()){
			try{
				int start = classes_.poll();
				printVirtualTable(class_list.get(no_class.get(start)), parent_, out);
				Iterator<Integer> it1 = matrix.get(start).iterator();
				while(it1.hasNext()){
					int push = it1.next();
					classes_.offer(push);
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

		startc = name_class.get("Main");
		class_f = startc.features;

		reset();
		while(!classes_.isEmpty()){
			try{
				int start = classes_.poll();
				printmethods(class_list.get(no_class.get(start)), parent_, out);
				Iterator<Integer> ix1 = matrix.get(start).iterator();
				while(ix1.hasNext()){
					int push = ix1.next();
					classes_.offer(push);
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

		firstPass(startc, out);

		Iterator<class_> class_it = program.classes.iterator();
		while(class_it.hasNext()){
			class_ get_class = class_it.next();
			String get_name = get_class.name;
			if(get_name.equals("Main")){
				continue;
			}
			class_f = get_class.features;
			Iterator<feature> itf = class_f.iterator();
			while(itf.hasNext()){
				feature f = itf.next();
				expr = get_expr();
				attr temp_attr;
				method temp_method;
				if(f instanceof method){
					temp_method = (method) f;
					get_expression(temp_method.body, out);
				}
				else if(f instanceof attr){
					temp_attr = (attr) f;
					get_expression(temp_attr.value, out);
				}
			}
		}
	}
}
