--Calculate Power and Factorial using COOL Language
class Main inherits IO {
  factorial(n : Int) : Int {                    --tail recursive factorial helper function
    tail_recursion(n, 1)
  };

  tail_recursion(n : Int, k : Int) : Int {      --tail_recursion for factorial
    if n < 2 then                               --base case
      k
    else
      tail_recursion(n - 1, k*n)                --multiply arg and decrement counter for next multiplication
    fi
  };
                                                --tail recursive method to calculate X^y
  tail_recursion_power(x : Int, y : Int, acc : Int) : Int {
    if y = 0 then                               --base case
      acc
    else
        tail_recursion_power(x, y - 1, x*acc)   --multiply arg and decrement counter for next multiplication
    fi
  };

  n : Int;                                      --initializing class member variables
  power : Int;

  main() : Object {
    {                                           --input
      out_string("Enter a non-negative integer : ");
      n <- in_int();                            --store the input in n
      let num : Int <- n in                     --local scope for num
        if num < 0 then                         --error handling
          out_string("Invalid input, please enter a non-negative integer.\n")
        else {
          out_string("The factorial of ");
          out_int(num);
          out_string(" is ");
          out_int(factorial(num));              --call the factorial method
          out_string(".\n");
          out_string("Enter the power : ");
          power <- in_int();                    --input of exponent for power function
          out_string("The power of ");
          out_int(num);                         --output printing
          out_string(" raised to ");
          out_int(power);
          out_string(" is ");                   --call the power method
          out_int(tail_recursion_power(num, power, 1));
          out_string(".\n");
        }
        fi;
    }
  };
};
