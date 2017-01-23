class List inherits IO {

  isNil() : Bool { true };

  head()  : Int { { abort(); 0; } };

  tail()  : List { { abort(); self; } };

  cons(i : Int) : List {
    (new Cons).init(i, self)
  };

  append(element : Int, list : List) : List {
    list.cons(element)
  };

  createArray(size : Int, element : Int) : List {
    if size = 1 then {
      cons(element <- element + 1);
    }
    else {
      append(element <- element + 1, createArray(size - 1, element));
    }
    fi
  };

  getAt(index : Int, mylist : List) : Int {
    if index = 0 then {
      mylist.head();
    }
    else {
      getAt(index - 1, mylist.tail());
    }
    fi
  };

  size_list(mylist : List) : Int {
    if mylist.isNil() then 0
    else {
		  1 + size_list(mylist.tail());
		}
    fi
  };

  reverse() : List {
    let mylist : List <- new List in {
      let j : Int <- 0 in {
        while j < self.size_list(self) loop {
          mylist <- mylist.cons(self.getAt(j, self));
          j <- j + 1;
        }
        pool;
      };
      mylist;
    }
  };

  setAt(index : Int, element : Int) : Object {
    setAt(index, element)
  };

};

class Cons inherits List {

  car : Int;	-- The element in this list cell

  cdr : List;	-- The rest of the list

  isNil() : Bool { false };

  head()  : Int { car };

  tail()  : List { cdr };

  init(i : Int, rest : List) : List {
    {
	    car <- i;
	    cdr <- rest;
	    self;
    }
  };

  setAt(index : Int, element : Int) : Object {
    if index = 0 then {
      car <- element;
    }
    else {
      cdr.setAt(index - 1, element);
    }
    fi
  };

};

class Main inherits IO {

  n : Int;
  mylist : List;
  inputlist : List;
  sorted_list : List;

  print_list(l : List) : Object {
    if l.isNil() then out_string("\n")
    else {
		  out_int(l.head());
		  out_string(" ");
		  print_list(l.tail());
		}
    fi
  };

  and(b1 : Bool, b2 : Bool) : Bool {
     if b1 then b2 else false fi
  };

  merge(array : List, left : Int, mid : Int, right : Int) : Object {
    (let i : Int <- 0, j : Int <- 0, k : Int <- 0, n1 : Int <- (mid - left + 1), n2 : Int <- (right - mid) in {
      let templist1 : List <- (new List).createArray(n1, 0), templist2 : List <- (new List).createArray(n2, 0) in {
        i <- 0;
        while i < n1 loop {
          templist1.setAt(i, array.getAt(left + i, array));
          i <- i + 1;
        }
        pool;
        j <- 0;
        while j < n2 loop {
          templist2.setAt(j, array.getAt(mid + 1 + j, array));
          j <- j + 1;
        }
        pool;
        i <- 0;
        j <- 0;
        k <- left;
        while and(i < n1, j < n2) loop {
          if(templist1.getAt(i, templist1) <= templist2.getAt(j, templist2)) then {
            array.setAt(k, templist1.getAt(i, templist1));
            i <- i + 1;
          }
          else {
            array.setAt(k, templist2.getAt(j, templist2));
            j <- j + 1;
          }
          fi;
          k <- k + 1;
        }
        pool;
        while i < n1 loop {
          array.setAt(k, templist1.getAt(i, templist1));
          i <- i + 1;
          k <- k + 1;
        }
        pool;
        while j < n2 loop {
          array.setAt(k, templist2.getAt(j, templist2));
          j <- j + 1;
          k <- k + 1;
        }
        pool;
      };
    })
  };

  mergesort(array : List, left : Int, right : Int) : List {
    {
      if left < right then {
        mergesort(array, left, (left + right)/2);
        mergesort(array, (left + right)/2 + 1, right);
        merge(array, left, (left + right)/2, right);
      }
      else {
        array;
      }
      fi;
      array;
    }
  };

  main() : Object {
    {
      --Method for reversing an array
      --mylist <- mylist.reverse();
      out_string("Enter the number of elements : ");
      n <- in_int();
      inputlist <- (new List).createArray(n, 0);
      let i : Int <- 0, input : Int in {
        while i < n loop {
          out_string("Enter : ");
          input <- in_int();
          inputlist.setAt(i, input);
          i <- i + 1;
        }
        pool;
      };
      sorted_list <- mergesort(inputlist, 0, n - 1);
      out_string("Sorted List : ");
      print_list(sorted_list);
    }
  };

};
