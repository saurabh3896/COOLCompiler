class Main inherits IO {
  input1 : String;
  input2 : String;
  input3 : String;
  main() : IO {
    {
      input1 <- 1 + "2";           --semantic error, not catched by the parser
      Input1 <- "Test Stri";       --error due to non-enclosing Strings in double-quotes ("...")
      input2 <- "Test \\n\n String2";
      input3 <- "Not \t single\c\h\a\r";
      out_string(input1.concat("\n"));
      out_string(input2.concat("\n"));
      out_string(input3.concat("\n"));
    }
  };
};
