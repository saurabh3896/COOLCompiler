package cool;

import java.io.*;
import java.util.*;

import cool.AST.*;
import cool.Cyclecheck;

public class Semantic{
	private boolean errorFlag = false;
	public void reportError(String filename, int lineNo, String error){
		errorFlag = true;
		System.err.println(filename+":"+lineNo+": "+error);
	}
	public boolean getErrorFlag(){
		return errorFlag;
	}

/*
	Don't change code above this line
*/
	HashMap<String, String> class_to_parent, child_parent;
	HashMap<String, Integer> class_no, c_l;
	HashMap<Integer, String> reverse_map;
	HashMap<String, struct> set;
	HashMap<String, class_> get_class;
	HashMap<String, List<String>> parent_childlist;
	HashMap<String, method> temp_map, temp_map_io, meth_map, temp_map_str;
	HashMap<String, attr> attr_map;
	List<formal> formal_arg_list = new ArrayList<>();
	List<int []> edges;
	List<class_> class_list;
	ScopeTable<attr> scope;
	Queue<Integer> classes_;
	String filename;

	boolean equal_args(method m1, method m2){
		//checking if the number of arguements in the declaration and definition of a method is same
		return (m1.formals.size() == m2.formals.size());
	}

	boolean same_types(method m1, method m2){
		//checking if return-types of methods are same or not
		return (m1.typeid.equals(m2.typeid));
	}

	boolean same_types(formal m1, formal m2){
		//checking if types of formal arguements to a method are same of not
		return (m1.typeid.equals(m2.typeid));
	}

	class struct{
		//struct to store class's internal structure
		String class_name, parent = null, filename;
		HashMap<String, method> list_methods;
		HashMap<String, attr> list_attrs;
		public struct(String clname, String pname, String filename, HashMap<String, attr> al, HashMap<String, method> ml){
			this.class_name = clname;	this.parent = pname;	this.filename = filename;
			this.list_attrs = new HashMap<String, attr>();
			Iterator<Map.Entry<String, attr>> it = al.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry<String, attr> entry = it.next();
				this.list_attrs.put(entry.getKey(), entry.getValue());
			}
			this.list_methods = new HashMap<String, method>();
			Iterator<Map.Entry<String, method>> ix = ml.entrySet().iterator();
			while(ix.hasNext()){
				Map.Entry<String, method> entry = ix.next();
				this.list_methods.put(entry.getKey(), entry.getValue());
			}
		}
	};

	boolean compatible(String class_a, String class_b){
		//keep backtracking till the classes not become equal, if reach null, that is parent of Object, return false
		while(true){
			if(class_a.equals(class_b))
				return true;
			else{
				try{
					class_a = set.get(class_a).parent;
				}
				catch(Exception e){
					System.out.println("The program probably contains SELF_TYPE. This semantic analyzer doesn't work for SELF_TYPE type.");
				}
				//backtracking step, if reaches null, return false
				if(class_a == null)
					return false;
			}
		}
	}

	//fill the parent to child and vice versa mapping
	public void fill_parent_table(){
		List<class_> newlist = new ArrayList<>(class_list);
		Iterator<class_> it = newlist.iterator();
		List<String> special_meths = new ArrayList<>(Arrays.asList("Bool", "Int", "IO", "String"));
		c_l.put("Object", 0);
		parent_childlist.put("Object", special_meths);
		for(String temp : special_meths){
			//basic classes have Object class as their parent
			try{
				child_parent.put(temp, "Object");
				c_l.put(temp, 1);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		while(it.hasNext()){
			//fill the parent -> child mapping
			class_ current = it.next();
			String name = current.name, parent = set.get(name).parent;
			child_parent.put(name, parent);
			//in the same loop, put the parent of each class in a separate HashMap
			if(!parent_childlist.containsKey(parent)){
				List<String> temp = new ArrayList<>();
				try{
					temp.add(name);
					parent_childlist.put(parent, temp);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			else{
				parent_childlist.get(parent).add(name);
			}
		}
	}

	//add classes and check for inheritance, overloading and redefinition errors
	public void Add(String name, String pname){
		class_ curr_class = get_class.get(name), curr_parent_class = get_class.get(pname);
		HashMap<String, attr> pa_list = new HashMap<>(), ca_list = new HashMap<>();
		HashMap<String, method> pm_list = new HashMap<>(), cm_list = new HashMap<>();
		struct copy = new struct(name, pname, curr_class.filename, set.get(pname).list_attrs, set.get(pname).list_methods);
		pa_list = copy.list_attrs; pm_list = copy.list_methods;
		boolean flag_ = false, flag__ = false;
		List<feature> flist = curr_class.features;
		//iterate through the feature list
		for(feature feat : flist){
			if(feat instanceof attr){
				//if the current feature is an attribute
				if(pa_list.get(((attr) feat).name) != null){
					flag_ = true;
					reportError(curr_class.filename, ((attr) feat).lineNo, "Attribute " + ((attr) feat).name + " is an attribute of an inherited class.");
				}
			}
			else{
				//else the current feature is a method
				method pmeth = pm_list.get(((method) feat).name), cmeth = (method) feat;
				if(pmeth == null){
					continue;
				}
				if(!same_types(pmeth, cmeth)){
					//types should be same for both expected and actual methods, same pattern is followed many times
					flag__ = true;
					reportError(curr_class.filename, cmeth.lineNo, "In redefined method " + cmeth.name + ", return type "
						+ cmeth.typeid + " is different from original return type " + pmeth.typeid + ".");
				}
				else{
					flag__ = true;
					if(!equal_args(pmeth, cmeth)){
						//method should have same expected and declared (actual) return type, as well as same number of parameters passed
						reportError(curr_class.filename, cmeth.lineNo, "Incompatible number of formal parameters in redefined method " + cmeth.name + ".");
					}
					else{
						Iterator<formal> it1 = cmeth.formals.iterator(), it2 = pmeth.formals.iterator();
						while(it1.hasNext() && it2.hasNext()){
							formal f1 = it1.next(), f2 = it2.next();
							if(!same_types(f1, f2)){
								reportError(curr_class.filename, cmeth.lineNo, "In redefined method " + cmeth.name + ", parameter type "
									+ f1.typeid + " is different from original type " + f2.typeid);
								break;
							}
						}
					}
				}
			}
		}
		Iterator<feature> it = flist.iterator();
		//iterate through the features again for multiple definitions check of single attribute/method
		while(it.hasNext()){
			feature ft = it.next();
			if(ft instanceof attr){
				//if the feature is an attribute
				attr aft = (attr) ft;
				//check for multiple attribute definitions
				try{
					if(ca_list.get(aft.name) == null)
						ca_list.put(aft.name, aft);
					else
						reportError(curr_class.filename, aft.lineNo, "Attribute " + aft.name + " is multiply defined in class.");
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
			else{
				if(ft instanceof method){
					//else the feature is a method
					method mft = (method) ft;
					//check for multiple method definitions
					try{
						if(cm_list.get(mft.name) == null)
							cm_list.put(mft.name, mft);
						else
							reportError(curr_class.filename, mft.lineNo, "Method " + mft.name + " is multiply defined.");
					}
					catch(Exception ex){
						ex.printStackTrace();
					}
				}
				else
					reportError(curr_class.filename, ft.lineNo, "Invalid class feature neither conforms to a method nor an attr.");
			}
		}
		//attr errors check
		Iterator<Map.Entry<String, attr>> ix = ca_list.entrySet().iterator();
		while(ix.hasNext() && flag_ == false){
			Map.Entry<String, attr> en = ix.next();
			String key = en.getKey();	attr value = en.getValue();
			if(pa_list.get(key) == null)
				pa_list.put(key, value);
			else
				reportError(curr_class.filename, value.lineNo, "Attribute " + value.name + " is an attribute of an inherited class.");
		}
		//method errors check
		method pmeth, cmeth;
		Iterator<Map.Entry<String, method>> itr = cm_list.entrySet().iterator();
		int flag = -1;
		while(itr.hasNext()){
			Map.Entry<String, method> en = itr.next();
			String key = en.getKey();	cmeth = en.getValue();
			if((pmeth = pm_list.get(key)) == null){
				pm_list.put(key, cmeth);
			}
			else{
				if(flag__) continue;
				//also insert if method is correctly overloaded, precedence to error-check for return-type of method
				if(!same_types(pmeth, cmeth)){
					reportError(curr_class.filename, cmeth.lineNo, "In redefined method " + cmeth.name + ", return type "
						+ cmeth.typeid + " is different from original return type " + pmeth.typeid + ".");
				}
				else{
					if(!equal_args(pmeth, cmeth)){
						//argument's expected and actual type should be same
						reportError(curr_class.filename, cmeth.lineNo, "Incompatible number of formal parameters in redefined method " + cmeth.name + ".");
					}
					else{
						Iterator<formal> it1 = cmeth.formals.iterator(), it2 = pmeth.formals.iterator();
						while(it1.hasNext() && it2.hasNext()){
							formal f1 = it1.next(), f2 = it2.next();
							if(!same_types(f1, f2)){
								flag = 1;
								reportError(curr_class.filename, cmeth.lineNo, "In redefined method " + cmeth.name + ", parameter type "
									+ f1.typeid + " is different from original type " + f2.typeid);
								break;
							}
						}
						if(flag != 1){
							pm_list.put(key, cmeth);
						}
					}
				}
			}
			//all errors corresponding to attrs and methods checked by now
		}
		clear(name, pname);
		set.put(name, new struct(name, pname, curr_class.filename, pa_list, pm_list));
	}

	public void fillScope(){
		Iterator<class_> it = class_list.iterator();
		while(it.hasNext()){
			class_ e = it.next();
			scope.enterScope();
			//self attribute is present by default for each class, hence needs to be manually inserted in the ScopeTable
			scope.insert("self", new attr("self", e.name, new no_expr(e.lineNo), e.lineNo));
			HashMap<String, attr> list_attr = set.get(e.name).list_attrs;
			for(Map.Entry<String, attr> entry : list_attr.entrySet()){
				String key = entry.getKey();
				attr value = entry.getValue();
				scope.insert(key, value);
			}
			//iterate though each of the features in the class, and fill the ScopeTable according to its type (attr/method)
			Iterator<feature> ix = e.features.iterator();
			while(ix.hasNext()){
				feature ft = ix.next();
				if(ft instanceof attr){
					//process attr
					scope.enterScope();
					attr at = (attr) ft;
					if(!(at.value instanceof no_expr)){
						String attr_type = get_expr_type(at.value, e.filename);
						if(!compatible(at.value.type, at.typeid)){
							reportError(e.filename, at.value.lineNo, "Inferred type " + at.value.type + " of initialization of attribute "
								+ at.name + " does not conform to declared type " + at.typeid + ".");
						}
					}
					scope.exitScope();
				}
				else if(ft instanceof method){
					//process method
					scope.enterScope();
					processMethod((method) ft, e.filename);
					scope.exitScope();
				}
			}
			scope.exitScope();
		}
	}

	public void processMethod(method me, String filename){
		List<formal> formals = me.formals;
		Iterator<formal> it = formals.iterator();
		//iterate thought the formal attribute list of the method
		while(it.hasNext()){
			formal fm = it.next();
			if(scope.lookUpLocal(fm.name) != null){
				//ScopeTable shouldn't have the same variable present in its map
				reportError(filename, fm.lineNo, "Formal parameter " + fm.name + " is multiply defined.");
			}
			else{
				scope.insert(fm.name, new attr(fm.name, fm.typeid, new AST.no_expr(fm.lineNo), fm.lineNo));
			}
		}
		String t_ = get_expr_type(me.body, filename);
		//conformance check only after method's body is processed
		if(!compatible(me.body.type, me.typeid)){
			if(me.typeid.equals("SELF_TYPE")){
				reportError(filename, me.body.lineNo, "The declared return type of method " + me.name + " is SELF_TYPE. This semantic analyzer doesn't handle the case of SELF_TYPE.");
				return;
			}
			reportError(filename, me.body.lineNo, "Inferred return type " + me.body.type +
				" of method " + me.name + " does not conform to declared return type " + me.typeid + ".");
		}
	}

	//get the expression type of the argument expression, the default expression type of exp is "_no_type",
	//as one can see in the AST generated after the parser phase, once the type of the argument expression is set,
	//the same is attached to the AST generated, and the same is printed if the program is free from semantic errors.
	//Note that the if-elseif ladder is in the same order as the precedence order of each type of expression, as defined
	//in the COOL manual, and the function returns the same
	public String get_expr_type(expression e, String filename){
		//assign expression processing
		if(e instanceof assign){
			assign e_ = (assign) e;
			attr get_lhs_attr;
			String t_ = get_expr_type(e_.e1, filename);
			//global existence of expression should be true
			if(scope.lookUpGlobal(e_.name) == null)
				reportError(filename, e_.lineNo, "Assignment to undeclared variable " + e_.name + ".");
			else{
				//global existence of lhs expression should be true
				if((get_lhs_attr = scope.lookUpGlobal(e_.name)) != null){}
				if(!compatible(e_.e1.type, get_lhs_attr.typeid)){
					reportError(filename, e_.lineNo, "Type " + e_.e1.type + " of assigned expression does not conform to declared type "
						+ get_lhs_attr.typeid + " of identifier " + get_lhs_attr.name + ".");
				}
			}
			e.type = e_.e1.type;
			return e_.e1.type;
		}
		//static_dispatch expression processing
		else if(e instanceof static_dispatch){
			static_dispatch e_ = (static_dispatch) e;
			String get_caller_name = get_expr_type(e_.caller, filename);
			List<expression> args = e_.actuals;
			Iterator<expression> it = args.iterator();
			while(it.hasNext()){
				expression get = it.next();
				String t_ = get_expr_type(get, filename);
			}
			//the type, i.e., a class, should be defined
			//if the type of method's caller is not defined, no such class (the one calling the method) exists
			try{
				if(set.get(e_.typeid) == null)
					reportError(filename, e_.lineNo, "Static dispatch to undefined class " + e_.typeid + ".");
				//the only difference from dispatch expression processing is here, static dispatch should conform to the type of class calling the method
				else if(!compatible(get_caller_name, set.get(e_.typeid).class_name))
					reportError(filename, e_.lineNo, "Expression type " + get_caller_name + " does not conform to declared static dispatch type " + set.get(e_.typeid).class_name + ".");
				else{
					//iterate in method_list
					method key = null;
					try{
						key = set.get(e_.typeid).list_methods.get(e_.name);
					}
					catch(Exception ex){
						System.out.println("Caller dispatching to illegal method.");
						ex.printStackTrace();
					}
					if(key == null){
						reportError(filename, e_.lineNo, "Static dispatch to undefined method " + e_.name + ".");
						e.type = "Object";
						return "Object";
					}
					else{
						List<formal> flist = key.formals;
						if(flist.size() != args.size()){
							//number of arguments in declaration and definition of a method should be the same
							reportError(filename, e_.lineNo, "Method " + key.name + " invoked with wrong number of arguments.");
						}
						else{
							int count = 0;
							it = args.iterator();
							//iterate though the formal list in both original and redefined method, check if method properly overloaded or not
							Iterator<formal> ix = flist.iterator();
							while(it.hasNext() && ix.hasNext()){
								String par_name = flist.get(count).name;
								String t1 = it.next().type, t2 = ix.next().typeid;
								if(!compatible(t1, t2))
									reportError(filename, e_.lineNo, "In call of method " + key.name + ", type " + t1 + " of parameter " + par_name + " does not conform to declared type " + t2 + ".");
								count++;
							}
						}
						e.type = key.typeid;
						return key.typeid;
					}
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			e.type = "Object";
			return "Object";
		}
		//dispatch expression processing
		else if(e instanceof dispatch){
			dispatch e_ = (dispatch) e;
			String get_caller_name = get_expr_type(e_.caller, filename);
			List<expression> args = e_.actuals;
			Iterator<expression> it = args.iterator();
			while(it.hasNext()){
				expression get = it.next();
				String t_ = get_expr_type(get, filename);
			}
			//the type, i.e., a class, should be defined
			//if the type of method's caller is not defined, no such class (the one calling the method) exists
			if(set.get(get_caller_name) == null)
				reportError(filename, e_.lineNo, "Class " + get_caller_name + " is undefined.");
			else{
				//iterate in method_list
				method key = null;
				try{
					key = set.get(get_caller_name).list_methods.get(e_.name);
				}
				catch(Exception ex){
					System.out.println("Caller dispatching to illegal method.");
					ex.printStackTrace();
				}
				if(key == null){
					reportError(filename, e_.lineNo, "Dispatch to undefined method " + e_.name + ".");
					e.type = "Object";
					return "Object";
				}
				else{
					List<formal> flist = key.formals;
					if(flist.size() != args.size()){
						//number of arguments in declaration and definition of a method should be the same
						reportError(filename, e_.lineNo, "Method " + key.name + " invoked with wrong number of arguments.");
					}
					else{
						int count = 0;
						it = args.iterator();
						//iterate though the formal list in both original and redefined method, check if method properly overloaded or not
						Iterator<formal> ix = flist.iterator();
						while(it.hasNext() && ix.hasNext()){
							try{
								String par_name = flist.get(count).name;
								String t1 = it.next().type, t2 = ix.next().typeid;
								//types should be compatible
								if(!compatible(t1, t2))
									reportError(filename, e_.lineNo, "In call of method " + key.name + ", type " + t1 + " of parameter " + par_name + " does not conform to declared type " + t2 + ".");
								count++;
							}
							catch(Exception ex){
								ex.printStackTrace();
							}
						}
					}
					e.type = key.typeid;
					return key.typeid;
				}
			}
			e.type = "Object";
			return "Object";
		}
		//cond expression processing
		else if(e instanceof cond){
			cond e_ = (cond) e;
			String t_ = get_expr_type(e_.predicate, filename);
			if(!e_.predicate.type.equals("Bool"))
				reportError(filename, e_.predicate.lineNo, "Predicate of \'if\' does not have type Bool.");
			String t_1 = get_expr_type(e_.ifbody, filename), t_2 = get_expr_type(e_.elsebody, filename);
			try{
				e.type = lc_ancestor(e_.ifbody.type, e_.elsebody.type);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			return lc_ancestor(e_.ifbody.type, e_.elsebody.type);
		}
		//loop body processing
		else if(e instanceof loop){
			loop e_ = (loop) e;
			String t_ = get_expr_type(e_.predicate, filename);
			if(!e_.predicate.type.equals("Bool"))
				reportError(filename, e_.predicate.lineNo, "Loop condition does not have type Bool.");
			String t_1 = get_expr_type(e_.body, filename);
			e.type = "Object";
			return "Object";
		}
		//block expression processing
		else if(e instanceof block){
			block e_ = (block) e;
			List<expression> l = e_.l1;
			Iterator<expression> it = l.iterator();
			String type = null;
			while(it.hasNext()){
				try{
					expression exp = it.next();
					type = get_expr_type(exp, filename);
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
			e.type = type;
			return type;
		}
		//let expression processing
		else if(e instanceof let){
			let e_ = (let) e;
			scope.enterScope();
			scope.insert(e_.name, new attr(e_.name, e_.typeid, e_.value, e_.lineNo));
			String type1 = e_.typeid;
			if(!(e_.value instanceof no_expr)){
				try{
					String t_ = get_expr_type(e_.value, filename);
					if(!(e_.value instanceof no_expr) || !(e_.value.type).equals("_no_type")){
						if(!compatible(e_.value.type, type1)){
							reportError(filename, e_.lineNo, "Inferred type of " + e_.value.type + " of initialization of "
							 	+ e_.name + " does not conform to idenitifier's declared type " + type1 + ".");
						}
					}
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
			String t_1 = get_expr_type(e_.body, filename);
			e.type = e_.body.type;
			scope.exitScope();
			return e_.body.type;
		}
		//case branch expression processing
		else if(e instanceof typcase){
			//boolean variable stop is used to stop checking a branch's value, if its type is undefined
			boolean stop = false;
			typcase e_ = (typcase) e;
			List<branch> list_branch = e_.branches;
			HashMap<String, Integer> branch_map = new HashMap<>();
			String t_ = get_expr_type(e_.predicate, filename);
			scope.enterScope();

			//initialization of first branch predicate and value, and then do the same for all branches
			branch first_br = list_branch.get(0);
			String type = "Object", initial = "Object";
			if(set.get(first_br.type) != null){
				type = first_br.type;
			}
			else{
				//don't process the branch's value, if the branch's type is not defined, as done by the COOL compiler
				stop = true;
				reportError(filename, first_br.lineNo, "Class " + first_br.type + " of case branch is undefined.");
			}
			scope.insert(first_br.name, new attr(first_br.name, type, first_br.value, first_br.lineNo));
			if(!stop){
				initial = get_expr_type(first_br.value, filename);
			}
			branch_map.put(first_br.type, 1);

			scope.exitScope();
			stop = false;
			Iterator<branch> it = list_branch.iterator();
			it.next();
			while(it.hasNext()){
				stop = false;
				branch br = it.next();
				if(branch_map.get(br.type) != null){
					reportError(filename, br.lineNo, "Duplicate branch found " + br.type + " in case statement.");
				}
				else{
					branch_map.put(br.type, 1);
				}
				scope.enterScope();
				type = "Object";
				if(set.get(br.type) != null){
					type = br.type;
				}
				else{
					//don't process the branch's value, if the branch's type is not defined, as done by the COOL compiler
					stop = true;
					reportError(filename, br.lineNo, "Class " + br.type + " of case branch is undefined.");
				}
				scope.insert(br.name, new attr(br.name, type, br.value, br.lineNo));
				if(!stop){
					String new_type = get_expr_type(br.value, filename);
					initial = lc_ancestor(initial, new_type);
				}
				scope.exitScope();
			}
			//final type is lca of all encountered types
			e.type = initial;
			return initial;
		}
		//new_ expression processing
		else if(e instanceof new_){
			new_ e_ = (new_) e;
			if(set.get(e_.typeid) == null){
				reportError(filename, e_.lineNo, "\'new\' used with undefined class " + e_.typeid + ".");
				e.type = "Object";
				return "Object";
			}
			else{
				e.type = e_.typeid;
				return e_.typeid;
			}
		}
		//isvoid expression processing
		else if(e instanceof isvoid){
			isvoid e_ = (isvoid) e;
			e.type = "Bool";
			return "Bool";
		}
		//plus expression processing
		else if(e instanceof plus){
			plus e_ = (plus) e;
			String op_type1 = get_expr_type(e_.e1, filename), op_type2 = get_expr_type(e_.e2, filename);
			if(!(op_type1.equals("Int") && op_type2.equals("Int"))){
				reportError(filename, e_.lineNo, "non-Int arguments: " + op_type1 + " + " + op_type2);
			}
			e.type = "Int";
			return "Int";
		}
		//sub expression processing
		else if(e instanceof sub){
			sub e_ = (sub) e;
			String op_type1 = get_expr_type(e_.e1, filename), op_type2 = get_expr_type(e_.e2, filename);
			if(!(op_type1.equals("Int") && op_type2.equals("Int"))){
				reportError(filename, e_.lineNo, "non-Int arguments: " + op_type1 + " - " + op_type2);
			}
			e.type = "Int";
			return "Int";
		}
		//mul expression processing
		else if(e instanceof mul){
			mul e_ = (mul) e;
			String op_type1 = get_expr_type(e_.e1, filename), op_type2 = get_expr_type(e_.e2, filename);
			if(!(op_type1.equals("Int") && op_type2.equals("Int"))){
				reportError(filename, e_.lineNo, "non-Int arguments: " + op_type1 + " * " + op_type2);
			}
			e.type = "Int";
			return "Int";
		}
		//divide expression processing
		else if(e instanceof divide){
			divide e_ = (divide) e;
			String op_type1 = get_expr_type(e_.e1, filename), op_type2 = get_expr_type(e_.e2, filename);
			if(!(op_type1.equals("Int") && op_type2.equals("Int"))){
				reportError(filename, e_.lineNo, "non-Int arguments: " + op_type1 + " / " + op_type2);
			}
			e.type = "Int";
			return "Int";
		}
		//comp expression processing
		else if(e instanceof comp){
			comp e_ = (comp) e;
			String t_ = get_expr_type(e_.e1, filename);
			if(!e_.e1.type.equals("Bool")){
				reportError(filename, e_.lineNo, "Argument of \'not\' has type " + e_.e1.type + " instead of Bool.");
			}
			e.type = "Bool";
			return "Bool";
		}
		//lessthan (lt) expression processing
		else if(e instanceof lt){
			lt e_ = (lt) e;
			String op_type1 = get_expr_type(e_.e1, filename), op_type2 = get_expr_type(e_.e2, filename);
			if(!(op_type1.equals("Int") && op_type2.equals("Int"))){
				reportError(filename, e_.lineNo, "non-Int arguments: " + op_type1 + " < " + op_type2);
			}
			e.type = "Bool";
			return "Bool";
		}
		//lessthanorequal (leq) expression processing
		else if(e instanceof leq){
			leq e_ = (leq) e;
			String op_type1 = get_expr_type(e_.e1, filename), op_type2 = get_expr_type(e_.e2, filename);
			if(!(op_type1.equals("Int") && op_type2.equals("Int"))){
				reportError(filename, e_.lineNo, "non-Int arguments: " + op_type1 + " <= " + op_type2);
			}
			e.type = "Bool";
			return "Bool";
		}
		//equal (eq) expression processing
		else if(e instanceof eq){
			eq e_ = (eq) e;
			String type1 = get_expr_type(e_.e1, filename), type2 = get_expr_type(e_.e2, filename);
			Map<String, Integer> types = new HashMap<>();
			types.put("Bool", 1);	types.put("Int", 1); types.put("String", 1);
			if(types.get(type1) != null || types.get(type2) != null){
				if(!type1.equals(type2)){
					reportError(filename, e_.lineNo, "Illegal comparison with a basic type.");
				}
			}
			e.type = "Bool";
			return "Bool";
		}
		//negative of a number (~a, a : Int)
		else if(e instanceof neg){
			neg e_ = (neg) e;
			String type = get_expr_type(e_.e1, filename);
			if(!type.equals("Int")){
				reportError(filename, e_.lineNo, "Argument of \'~\' has type " + type + " instead of Int.");
			}
			e.type = "Int";
			return "Int";
		}
		//object type processing
		else if(e instanceof object){
			object e_ = (object) e;
			if(scope.lookUpGlobal(e_.name) != null){
				e.type = scope.lookUpGlobal(e_.name).typeid;
				return scope.lookUpGlobal(e_.name).typeid;
			}
			else{
				reportError(filename, e_.lineNo, "Undeclared identifier " + e_.name + ".");
				e.type = "Object";
				return "Object";
			}
		}
		//int constant
		else if(e instanceof int_const){
			int_const e_ = (int_const) e;
			e.type = "Int";
			return "Int";
		}
		//string constant
		else if(e instanceof string_const){
			string_const e_ = (string_const) e;
			e.type = "String";
			return "String";
		}
		//bool constant
		else if(e instanceof bool_const){
			bool_const e_ = (bool_const) e;
			e.type = "Bool";
			return "Bool";
		}
		return "_no_type";
	}

	public void clear(String ch, String par){
		c_l.put(ch, c_l.get(par) + 1);
	}

	public String lc_ancestor(String str1, String str2){
		//function to return lca of two classes in the graph
		while(true){
			if(str1.equals(str2)){
				//return if common parent found
				return str1;
			}
			else if(c_l.get(str1) < c_l.get(str2)){
				//first class at higher level
				String temp = str1;
				str1 = str2;
				str2 = temp;
			}
			else{
				//else set first class to its parent if already at higher level, till reach the common ancestor
				str1 = set.get(str1).parent;
			}
		}
	}

	//filling special methods of basic classes, thus defining them
	public void fill_meth_map(){
		/**************************************************************************/
		temp_map.put("abort", new method("abort", formal_arg_list, "Object", new expression(), 1));
		temp_map.put("type_name", new method("type_name", formal_arg_list, "String", new expression(), 1));
		temp_map.put("copy", new method("copy", formal_arg_list, "SELF_TYPE", new expression(), 1));
		/**************************************************************************/
		temp_map_io.put("out_string", new method("out_string", new ArrayList<AST.formal>(Arrays.asList(new AST.formal("out_string", "String", 0))), "IO", new expression(), 1));
		temp_map_io.put("out_int", new method("out_int", new ArrayList<AST.formal>(Arrays.asList(new AST.formal("out_int", "Int", 0))), "IO", new expression(), 1));
		temp_map_io.put("in_string", new method("in_string", formal_arg_list, "String", new expression(), 1));
		temp_map_io.put("in_int", new method("in_int", formal_arg_list, "Int", new expression(), 1));
		/**************************************************************************/
		temp_map_str.put("length", new method("length", formal_arg_list, "Int", new expression(), 1));
		temp_map_str.put("concat", new method("concat", new ArrayList<>(Arrays.asList(new AST.formal("s", "String", 0))), "String", new expression(), 1));
		temp_map_str.put("substr", new method("substr", new ArrayList<>(Arrays.asList(new AST.formal("i", "Int", 0), new AST.formal("l", "Int", 0))), "String", new expression(), 1));
		/**************************************************************************/
	}

	public Semantic(AST.program program){
		//Write Semantic analyzer code here
		int counter = 1;
		boolean ismain = false, hasmainmethod = false;
		String temp, parent;
		//initialization of all global HashMaps and Lists
		class_to_parent = new HashMap<>();
    class_no = new HashMap<>();
		reverse_map = new HashMap<>();
		set = new HashMap<>();
		parent_childlist = new HashMap<>();
		child_parent = new HashMap<>();
		c_l = new HashMap<>();
		temp_map = new HashMap<>();
		temp_map_io = new HashMap<>();
		meth_map = new HashMap<>();
		temp_map_str = new HashMap<>();
		attr_map = new HashMap<>();
		get_class = new HashMap<>();
		scope = new ScopeTable<>();
		edges = new ArrayList<>();
		class_list = new ArrayList<>();
		classes_ = new ArrayDeque<>();

		class_list = program.classes;
		filename = class_list.get(0).filename;

    class_no.put("Object", 0);
    class_no.put("IO", 1);

		boolean primitive_err = false;
    for(class_ curr : class_list){
			//iterate though the class list
			temp = curr.name;	parent = curr.parent;
			if(temp.equals("Object") || temp.equals("IO") || temp.equals("Int") || temp.equals("Bool") || temp.equals("String")){
				//above classes are the basic classes, hence they can't be redefined
				primitive_err = true;
				reportError(curr.filename, curr.lineNo, "Redefinition of basic class " + curr.name + ".");
			}
			if(parent.equals("Int") || parent.equals("Bool") || parent.equals("String")){
				//inheritance from basic type classes is not possible
				primitive_err = true;
				reportError(curr.filename, curr.lineNo, "Class " + curr.name + " cannot inherit class " + parent + ".");
			}
			get_class.put(temp, curr);
			//alternative to "dangerous" containsKey
			String temp_ = class_to_parent.get(curr.name);
			if(temp_ == null){
				//check for unique class
				//as value will be null since class is new, it will be inserted in a map from class to its parent
        class_no.put(temp, ++counter);
        if(temp.equals("Main")){
					//check if Main class has main method or not here only
					ismain = true;
					List<feature> curr_features = curr.features;
					for(int i = 0;i < curr_features.size();i++){
            method me = null;
            if(curr_features.get(i) instanceof AST.method)
						  me = (method) curr_features.get(i);
						if(curr_features.get(i) instanceof AST.method && me.name.equals("main")){
							hasmainmethod = true;
						}
						else{
							//continue to check if other methods can be main, problem of multiple main methods will be reolved in next pass
						}
					}
				}
				//Need to check if Main class needs any special storing
				class_to_parent.put(temp, parent);
			}
			//value not found null for a particular class name, this means same class name has appeared again, report error
			else{
				primitive_err = true;
				reportError(curr.filename, curr.lineNo, "Class " + curr.name + " was previously defined.");
			}
		}
		//iterate though all the classes, and ensure that each class has its parent in the same list containing the current class
		Iterator<class_> it = program.classes.iterator();
		while(it.hasNext()){
			class_ get = it.next();
			if(!class_no.containsKey(get.parent)){
				//no class found corresponding to the declared parent class of the current class
				primitive_err = true;
				reportError(get.filename, get.lineNo, "Class " + get.name + " inherits from an undefined class " + get.parent + ".");
			}
		}
		if(primitive_err){
			System.exit(1);
		}
		//Check for inheritance cycles assuming that every class has a well defined parent class as well
		//can do by doing dfs over the directed graph, graph is built using HashMap, which stores node no. for every class
		for(Map.Entry<String, Integer> entry : class_no.entrySet()){
    	reverse_map.put(entry.getValue(), entry.getKey());
		}
		for(class_ cl : class_list){
			int u = class_no.get(cl.name), v = class_no.get(cl.parent);
			int [] t_ = {v, u};
			edges.add(t_);
		}
		//after making a directed graph, and checking for any inheritance cycles
		int [][] matrix = new int[edges.size()][];
    	matrix = edges.toArray(matrix);
    	Cyclecheck hascycle = new Cyclecheck(matrix, class_list.size());
		if(Cyclecheck.check()){
			for(Integer e : Cyclecheck.cycle_nodes){
				reportError(filename, 1, "Class " + reverse_map.get(e) + ", or an ancestor of " + reverse_map.get(e) + ", is involved in an inheritance cycle.");
			}
			System.exit(1);
		}
		//reach here, assuming no cycles, now store information for each class, we need to check each class's methods and
		//attributes now, and find semantic errors in them, we store all classes in a queue
		fill_meth_map();
		//class Object has parent "null"
		set.put("Object", new struct("Object", null, filename, attr_map, temp_map));
		set.put("Bool", new struct("Bool", "Object", filename, attr_map, meth_map));
		set.get("Bool").list_methods.putAll(temp_map);
		set.put("IO", new struct("IO", "Object", filename, attr_map, temp_map_io));
		set.get("IO").list_methods.putAll(temp_map);
		set.put("Int", new struct("Int", "Object", filename, attr_map, meth_map));
		set.get("Int").list_methods.putAll(temp_map);
		set.put("String", new struct("String", "Object", filename, attr_map, temp_map_str));
		set.get("String").list_methods.putAll(temp_map);
		//if each of the above four basic classes, class Object is the default parent of all
		List<String> special_meths = new ArrayList<>(Arrays.asList("Bool", "Int", "IO", "String"));
		c_l.put("Object", 0);
		for(String s : special_meths){
			c_l.put(s, 1);
		}
		boolean [] visited = new boolean[class_list.size() + 2];
		Arrays.fill(visited, false);
		for(int i = 0;i < class_list.size() + 2;i++){
			if(visited[i]){
				//leave the class if already visited
				continue;
			}
			classes_.offer(i);
			//mark the class as visited
			visited[i] = true;
			while(!classes_.isEmpty()){
				int get = classes_.poll();
				//Insert all info here
				try{
					if(!reverse_map.get(get).equals("IO") && !reverse_map.get(get).equals("Object")){
						//get the node numbers
						Add(reverse_map.get(get), get_class.get(reverse_map.get(get)).parent);
					}
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				for(int [] edge : edges){
					//traversing through the edges and inserting the classes into the queue
					if(get == edge[0] && visited[edge[1]] == false){
						classes_.offer(edge[1]);
						visited[edge[1]] = true;
					}
				}
			}
		}
		//fill the parent to child and vice versa mappings
		fill_parent_table();
		//fill the ScopeTable
		fillScope();
		//check for main method and Main class existence
		if(!ismain){
			reportError(filename, 1, "Class Main is not defined.");
		}
		if(ismain == true && !hasmainmethod){
			reportError(filename, 1, "No \'main\' method in class Main.");
		}
	}
}
