class Main inherits IO {
  n : Int <- 1;
  c : Int <- "a";             --error due to assigning String to Int Variable
  k : int <- 2;               --error due to lowercasing starting letter of a type-identifier
  A : String <- "Test";
  main() : Object {
    {
      let c : Int <- n + k in {
        out_int(c);           --not able to parse "a" as a string, generating an error
        out_int("1");         --error due to passing a String to an Int-accepting function
        out_string(("\n").concat(A.concat("\n")));  --error due to uppercasing first letter of an identifier, which is a String
      };
    }
  };
};
