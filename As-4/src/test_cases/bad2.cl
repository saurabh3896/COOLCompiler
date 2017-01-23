class Main inherits IO {
    factorial(x : Int) : Int {
        let a : Int <- 1, b : Int <- 1 in {
            while(i < x) loop {
                b <- b * i;
                i <- i + 1;
            }
            pool;
            b;
        }
    };
    main() : Object {
        {
            out_string("Enter n to find factorial : ");
            out_int(factorial(in_string()));
        }
    };
};
