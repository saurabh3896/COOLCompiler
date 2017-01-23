class Main inherits IO {
  n : Int;                      --initialize main class member variables
  c : Int;
  k : Int;
  space : Int <- 1;             --initialize space variable for " " between "*"
  main() : Object {
    {
      out_string("Enter the maximum degree of diamond : ");
      n <- in_int();
      space <- n - 1;
      k <- 1;

      while k <= n loop {       --while loop to print upper portion of diamond
        c <- 1;
        while c <= space loop { --iterate over each line to print corresponding diamond to print space
          out_string(" ");
          c <- c + 1;           --increment counter variable
        }
        pool;

        space <- space - 1;     --iterate over each line to print corresponding diamond to print "*"
        c <- 1;
        while c <= 2*k - 1 loop {
          out_string("*");
          c <- c + 1;           --increment counter variable
        }
        pool;

        out_string("\n");       --print newline char after each line
        k <- k + 1;             --increment counter variable
      }
      pool;

      space <- 1;               --reinitialize space variable for downward printing
      k <- 1;
      while k <= n - 1 loop {   --while loop to print lower portion of diamond
        c <- 1;
        while c <= space loop { --iterate over each line to print corresponding diamond to print space
          out_string(" ");
          c <- c + 1;           --increment counter variable
        }
        pool;

        space <- space + 1;
        c <- 1;                 --iterate over each line to print corresponding diamond to print "*"
        while c <= 2*(n - k) - 1 loop {
          out_string("*");
          c <- c + 1;           --increment counter variable
        }
        pool;

        out_string("\n");       --print newline char after each line
        k <- k + 1;             --increment counter variable
      }
      pool;
    }
  };
};
