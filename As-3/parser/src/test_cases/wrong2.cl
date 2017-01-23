class Main {
	a : Int <- 1 + 2*3;
	main():IO {
		new IO.out_string("Hello world!\n")
		out_string(a);	--parser should catch error here
	};
};
