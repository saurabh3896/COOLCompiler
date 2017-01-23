class Main inherits IO {
    x : Int;
    y : String;
	main() : Object {
	    {
            out_string("Enter : ");
		    x <- in_int();
            y <- x + 2;
            out_string(x);
	    }
    };
};
