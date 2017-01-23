--Arrays(Array Implementation done in mergesort program) + TicTacToe Implementation
class List inherits IO {

  isNil() : Bool { true };

  head()  : String { { abort(); ""; } };

  tail()  : List { { abort(); self; } };

  cons(i : String) : List {
    (new Cons).init(i, self)
  };

  append(element : String, list : List) : List {
    list.cons(element)
  };

  createArray(size : Int, element : String) : List {
    if size = 1 then {
      cons(element);
    }
    else {
      append(element, createArray(size - 1, element));
    }
    fi
  };

  getAt(index : Int, mylist : List) : String {
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

  setAt(index : Int, element : String) : Object {
    setAt(index, element)
  };

};

class Cons inherits List {

  car : String;	-- The element in this list cell

  cdr : List;	  -- The rest of the list

  isNil() : Bool { false };

  head()  : String { car };

  tail()  : List { cdr };

  init(i : String, rest : List) : List {
    {
	    car <- i;
	    cdr <- rest;
	    self;
    }
  };

  setAt(index : Int, element : String) : Object {
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

  cell : List;
  player_counter : Int <- 1;
  i : Int <- ~1;
  choice : Int;
  mark : String;

  modulo(a : Int, b : Int) : Int {
    a - (a / b * b)
  };

  and(b1 : Bool, b2 : Bool) : Bool {
     if b1 then b2 else false fi
  };

  checkwin() : Int {
    {
      if and(cell.getAt(1, cell) = cell.getAt(2, cell), cell.getAt(2, cell) = cell.getAt(3, cell)) then {
        1;
      }
      else if and(cell.getAt(4, cell) = cell.getAt(5, cell), cell.getAt(5, cell) = cell.getAt(6, cell)) then {
        1;
      }
      else if and(cell.getAt(7, cell) = cell.getAt(8, cell), cell.getAt(8, cell) = cell.getAt(9, cell)) then {
        1;
      }
      else if and(cell.getAt(1, cell) = cell.getAt(4, cell), cell.getAt(4, cell) = cell.getAt(7, cell)) then {
        1;
      }
      else if and(cell.getAt(2, cell) = cell.getAt(5, cell), cell.getAt(5, cell) = cell.getAt(8, cell)) then {
        1;
      }
      else if and(cell.getAt(3, cell) = cell.getAt(6, cell), cell.getAt(6, cell) = cell.getAt(9, cell)) then {
        1;
      }
      else if and(cell.getAt(1, cell) = cell.getAt(5, cell), cell.getAt(5, cell) = cell.getAt(9, cell)) then {
        1;
      }
      else if and(cell.getAt(3, cell) = cell.getAt(5, cell), cell.getAt(5, cell) = cell.getAt(7, cell)) then {
        1;
      }
      else if and(not cell.getAt(1, cell) = "1",
                and(not cell.getAt(2, cell) = "2", and(not cell.getAt(3, cell) = "3", and(not cell.getAt(4, cell) = "4",
                and(not cell.getAt(5, cell) = "5", and(not cell.getAt(6, cell) = "6", and(not cell.getAt(7, cell) = "7"
                , and(not cell.getAt(8, cell) = "8", not cell.getAt(9, cell) = "9")))))))) then {
        0;
      }
      else {
        ~1;
      }
      fi fi fi fi fi fi fi fi fi;
    }
  };

  init__() : Object {
    {
      out_string("\n\n\tTic Tac Toe\n\n");
      out_string("Player-1 (X)  -  Player-2 (O)\n\n\n");
      out_string("     |     |     \n");
      out_string("  ");
      out_string(cell.getAt(1, cell));
      out_string("  |  ");
      out_string(cell.getAt(2, cell));
      out_string("  |  ");
      out_string(cell.getAt(3, cell));
      out_string("\n");
      out_string("_____|_____|_____\n");
      out_string("     |     |     \n");
      out_string("  ");
      out_string(cell.getAt(4, cell));
      out_string("  |  ");
      out_string(cell.getAt(5, cell));
      out_string("  |  ");
      out_string(cell.getAt(6, cell));
      out_string("\n");
      out_string("_____|_____|_____\n");
      out_string("     |     |     \n");
      out_string("  ");
      out_string(cell.getAt(7, cell));
      out_string("  |  ");
      out_string(cell.getAt(8, cell));
      out_string("  |  ");
      out_string(cell.getAt(9, cell));
      out_string("\n");
      out_string("     |     |     ");
      out_string("\n\n");
    }
  };

  main() : Object {
    {
      cell <- (new List).cons("9").cons("8").cons("7").cons("6").cons("5").cons("4").cons("3").cons("2").cons("1").cons("0");
      while i = ~1 loop {
        init__();
        if modulo(player_counter, 2) = 1 then {
          player_counter <- 1;
        }
        else {
          player_counter <- 2;
        }
        fi;
        out_string("Player ");
        out_int(player_counter);
        out_string(", enter your choice : ");
        choice <- in_int();
        if player_counter = 1 then {
          mark <- "X";
        }
        else {
          mark <- "O";
        }
        fi;
        if and(choice = 1, cell.getAt(1, cell) = "1") then {
          cell.setAt(1, mark);
        }
        else if and(choice = 2, cell.getAt(2, cell) = "2") then {
      	  cell.setAt(2, mark);
      	}
        else if and(choice = 3, cell.getAt(3, cell) = "3") then {
      	  cell.setAt(3, mark);
      	}
        else if and(choice = 4, cell.getAt(4, cell) = "4") then {
      	  cell.setAt(4, mark);
      	}
        else if and(choice = 5, cell.getAt(5, cell) = "5") then {
      	  cell.setAt(5, mark);
      	}
        else if and(choice = 6, cell.getAt(6, cell) = "6") then {
      	  cell.setAt(6, mark);
      	}
        else if and(choice = 7, cell.getAt(7, cell) = "7") then {
      	  cell.setAt(7, mark);
      	}
        else if and(choice = 8, cell.getAt(8, cell) = "8") then {
      	  cell.setAt(8, mark);
      	}
        else if and(choice = 9, cell.getAt(9, cell) = "9") then {
      	  cell.setAt(9, mark);
      	}
        else {
          out_string("\n    Invalid Move, Try again");
          player_counter <- player_counter - 1;
        }
        fi fi fi fi fi fi fi fi fi;
        i <- checkwin();
        player_counter <- player_counter + 1;
      }
      pool;
      init__();
      if i = 1 then {
        player_counter <- player_counter - 1;
        out_string("Player ");
        out_int(player_counter);
        out_string(" Wins !!!\n");
      }
      else {
        out_string("Game Draw !!!\n");
      }
      fi;
    }
  };
};
