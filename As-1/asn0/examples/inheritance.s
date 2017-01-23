	.data
	.align	2
	.globl	class_nameTab
	.globl	Main_protObj
	.globl	Int_protObj
	.globl	String_protObj
	.globl	bool_const0
	.globl	bool_const1
	.globl	_int_tag
	.globl	_bool_tag
	.globl	_string_tag
_int_tag:
	.word	3
_bool_tag:
	.word	4
_string_tag:
	.word	5
	.globl	_MemMgr_INITIALIZER
_MemMgr_INITIALIZER:
	.word	_NoGC_Init
	.globl	_MemMgr_COLLECTOR
_MemMgr_COLLECTOR:
	.word	_NoGC_Collect
	.globl	_MemMgr_TEST
_MemMgr_TEST:
	.word	0
	.word	-1
str_const15:
	.word	5
	.word	5
	.word	String_dispTab
	.word	int_const7
	.byte	0	
	.align	2
	.word	-1
str_const14:
	.word	5
	.word	5
	.word	String_dispTab
	.word	int_const4
	.ascii	"Ccc"
	.byte	0	
	.align	2
	.word	-1
str_const13:
	.word	5
	.word	5
	.word	String_dispTab
	.word	int_const4
	.ascii	"Bbb"
	.byte	0	
	.align	2
	.word	-1
str_const12:
	.word	5
	.word	5
	.word	String_dispTab
	.word	int_const4
	.ascii	"Aaa"
	.byte	0	
	.align	2
	.word	-1
str_const11:
	.word	5
	.word	6
	.word	String_dispTab
	.word	int_const8
	.ascii	"String"
	.byte	0	
	.align	2
	.word	-1
str_const10:
	.word	5
	.word	6
	.word	String_dispTab
	.word	int_const0
	.ascii	"Bool"
	.byte	0	
	.align	2
	.word	-1
str_const9:
	.word	5
	.word	5
	.word	String_dispTab
	.word	int_const4
	.ascii	"Int"
	.byte	0	
	.align	2
	.word	-1
str_const8:
	.word	5
	.word	6
	.word	String_dispTab
	.word	int_const0
	.ascii	"Main"
	.byte	0	
	.align	2
	.word	-1
str_const7:
	.word	5
	.word	5
	.word	String_dispTab
	.word	int_const9
	.ascii	"IO"
	.byte	0	
	.align	2
	.word	-1
str_const6:
	.word	5
	.word	6
	.word	String_dispTab
	.word	int_const8
	.ascii	"Object"
	.byte	0	
	.align	2
	.word	-1
str_const5:
	.word	5
	.word	8
	.word	String_dispTab
	.word	int_const10
	.ascii	"<basic class>"
	.byte	0	
	.align	2
	.word	-1
str_const4:
	.word	5
	.word	5
	.word	String_dispTab
	.word	int_const3
	.ascii	"\n"
	.byte	0	
	.align	2
	.word	-1
str_const3:
	.word	5
	.word	5
	.word	String_dispTab
	.word	int_const3
	.ascii	"i"
	.byte	0	
	.align	2
	.word	-1
str_const2:
	.word	5
	.word	5
	.word	String_dispTab
	.word	int_const3
	.ascii	"e"
	.byte	0	
	.align	2
	.word	-1
str_const1:
	.word	5
	.word	5
	.word	String_dispTab
	.word	int_const3
	.ascii	"a"
	.byte	0	
	.align	2
	.word	-1
str_const0:
	.word	5
	.word	8
	.word	String_dispTab
	.word	int_const11
	.ascii	"inheritance.cl"
	.byte	0	
	.align	2
	.word	-1
int_const11:
	.word	3
	.word	4
	.word	Int_dispTab
	.word	14
	.word	-1
int_const10:
	.word	3
	.word	4
	.word	Int_dispTab
	.word	13
	.word	-1
int_const9:
	.word	3
	.word	4
	.word	Int_dispTab
	.word	2
	.word	-1
int_const8:
	.word	3
	.word	4
	.word	Int_dispTab
	.word	6
	.word	-1
int_const7:
	.word	3
	.word	4
	.word	Int_dispTab
	.word	0
	.word	-1
int_const6:
	.word	3
	.word	4
	.word	Int_dispTab
	.word	8
	.word	-1
int_const5:
	.word	3
	.word	4
	.word	Int_dispTab
	.word	9
	.word	-1
int_const4:
	.word	3
	.word	4
	.word	Int_dispTab
	.word	3
	.word	-1
int_const3:
	.word	3
	.word	4
	.word	Int_dispTab
	.word	1
	.word	-1
int_const2:
	.word	3
	.word	4
	.word	Int_dispTab
	.word	999
	.word	-1
int_const1:
	.word	3
	.word	4
	.word	Int_dispTab
	.word	5
	.word	-1
int_const0:
	.word	3
	.word	4
	.word	Int_dispTab
	.word	4
	.word	-1
bool_const0:
	.word	4
	.word	4
	.word	Bool_dispTab
	.word	0
	.word	-1
bool_const1:
	.word	4
	.word	4
	.word	Bool_dispTab
	.word	1
class_nameTab:
	.word	str_const6
	.word	str_const7
	.word	str_const8
	.word	str_const9
	.word	str_const10
	.word	str_const11
	.word	str_const12
	.word	str_const13
	.word	str_const14
class_objTab:
	.word	Object_protObj
	.word	Object_init
	.word	IO_protObj
	.word	IO_init
	.word	Main_protObj
	.word	Main_init
	.word	Int_protObj
	.word	Int_init
	.word	Bool_protObj
	.word	Bool_init
	.word	String_protObj
	.word	String_init
	.word	Aaa_protObj
	.word	Aaa_init
	.word	Bbb_protObj
	.word	Bbb_init
	.word	Ccc_protObj
	.word	Ccc_init
Object_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
Aaa_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	Aaa.methoda
	.word	Aaa.get
	.word	Aaa.change
Bbb_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	Bbb.methoda
	.word	Aaa.get
	.word	Aaa.change
Ccc_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	Ccc.methoda
	.word	Aaa.get
	.word	Ccc.change
	.word	Ccc.methodc
String_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	String.length
	.word	String.concat
	.word	String.substr
Bool_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
Int_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
IO_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	IO.out_string
	.word	IO.out_int
	.word	IO.in_string
	.word	IO.in_int
Main_dispTab:
	.word	Object.abort
	.word	Object.type_name
	.word	Object.copy
	.word	IO.out_string
	.word	IO.out_int
	.word	IO.in_string
	.word	IO.in_int
	.word	Main.main
	.word	-1
Object_protObj:
	.word	0
	.word	3
	.word	Object_dispTab
	.word	-1
Aaa_protObj:
	.word	6
	.word	4
	.word	Aaa_dispTab
	.word	int_const7
	.word	-1
Bbb_protObj:
	.word	7
	.word	4
	.word	Bbb_dispTab
	.word	int_const7
	.word	-1
Ccc_protObj:
	.word	8
	.word	5
	.word	Ccc_dispTab
	.word	int_const7
	.word	0
	.word	-1
String_protObj:
	.word	5
	.word	5
	.word	String_dispTab
	.word	int_const7
	.word	0
	.word	-1
Bool_protObj:
	.word	4
	.word	4
	.word	Bool_dispTab
	.word	0
	.word	-1
Int_protObj:
	.word	3
	.word	4
	.word	Int_dispTab
	.word	0
	.word	-1
IO_protObj:
	.word	1
	.word	3
	.word	IO_dispTab
	.word	-1
Main_protObj:
	.word	2
	.word	3
	.word	Main_dispTab
	.globl	heap_start
heap_start:
	.word	0
	.text
	.globl	Main_init
	.globl	Int_init
	.globl	String_init
	.globl	Bool_init
	.globl	Main.main
Object_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Aaa_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	jal	Object_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Bbb_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	jal	Aaa_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Ccc_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	jal	Bbb_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
String_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	jal	Object_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Bool_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	jal	Object_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Int_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	jal	Object_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
IO_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	jal	Object_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Main_init:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	jal	IO_init
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Aaa.methoda:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Aaa.get:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	lw	$a0 12($s0)
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Aaa.change:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	la	$a0 int_const0
	sw	$a0 12($s0)
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Bbb.methoda:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Ccc.methoda:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	move	$a0 $s0
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Ccc.methodc:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	move	$a0 $s0
	bne	$a0 $zero label0
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label0:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Ccc.change:
	addiu	$sp $sp -12
	sw	$fp 12($sp)
	sw	$s0 8($sp)
	sw	$ra 4($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	la	$a0 int_const1
	sw	$a0 12($s0)
	lw	$fp 12($sp)
	lw	$s0 8($sp)
	lw	$ra 4($sp)
	addiu	$sp $sp 12
	jr	$ra	
Main.main:
	addiu	$sp $sp -24
	sw	$fp 24($sp)
	sw	$s0 20($sp)
	sw	$ra 16($sp)
	addiu	$fp $sp 4
	move	$s0 $a0
	la	$a0 int_const2
	bne	$a0 $zero label2
	la	$a0 str_const0
	li	$t1 1
	jal	_case_abort2
label2:
	lw	$t2 0($a0)
	blt	$t2 4 label3
	bgt	$t2 4 label3
	move	$s1 $a0
	move	$a0 $s1
	b	label1
label3:
	blt	$t2 3 label4
	bgt	$t2 3 label4
	move	$s1 $a0
	sw	$s1 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	sw	$s1 0($fp)
	bne	$a0 $zero label5
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label5:
	lw	$t1 8($a0)
	lw	$t1 16($t1)
	jalr		$t1
	lw	$s1 0($fp)
	b	label1
label4:
	jal	_case_abort
label1:
	la	$a0 Ccc_protObj
	jal	Object.copy
	jal	Ccc_init
	move	$s1 $a0
	bne	$s1 $zero label7
	la	$a0 str_const0
	li	$t1 1
	jal	_case_abort2
label7:
	lw	$t2 0($s1)
	blt	$t2 8 label8
	bgt	$t2 8 label8
	move	$s2 $s1
	la	$a0 str_const3
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	sw	$s1 0($fp)
	sw	$s2 4($fp)
	bne	$a0 $zero label9
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label9:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$s1 0($fp)
	lw	$s2 4($fp)
	b	label6
label8:
	blt	$t2 7 label10
	bgt	$t2 8 label10
	move	$s2 $s1
	la	$a0 str_const2
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	sw	$s1 0($fp)
	sw	$s2 4($fp)
	bne	$a0 $zero label11
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label11:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$s1 0($fp)
	lw	$s2 4($fp)
	b	label6
label10:
	blt	$t2 6 label12
	bgt	$t2 8 label12
	move	$s2 $s1
	la	$a0 str_const1
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	sw	$s1 0($fp)
	sw	$s2 4($fp)
	bne	$a0 $zero label13
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label13:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$s1 0($fp)
	lw	$s2 4($fp)
	b	label6
label12:
	jal	_case_abort
label6:
	la	$a0 str_const4
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	sw	$s1 0($fp)
	bne	$a0 $zero label14
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label14:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$s1 0($fp)
	la	$a0 Aaa_protObj
	jal	Object.copy
	jal	Aaa_init
	move	$s1 $a0
	bne	$s1 $zero label16
	la	$a0 str_const0
	li	$t1 1
	jal	_case_abort2
label16:
	lw	$t2 0($s1)
	blt	$t2 8 label17
	bgt	$t2 8 label17
	move	$s2 $s1
	la	$a0 str_const3
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	sw	$s1 0($fp)
	sw	$s2 4($fp)
	bne	$a0 $zero label18
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label18:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$s1 0($fp)
	lw	$s2 4($fp)
	b	label15
label17:
	blt	$t2 7 label19
	bgt	$t2 8 label19
	move	$s2 $s1
	la	$a0 str_const2
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	sw	$s1 0($fp)
	sw	$s2 4($fp)
	bne	$a0 $zero label20
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label20:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$s1 0($fp)
	lw	$s2 4($fp)
	b	label15
label19:
	blt	$t2 0 label21
	bgt	$t2 8 label21
	move	$s2 $s1
	la	$a0 str_const1
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	sw	$s1 0($fp)
	sw	$s2 4($fp)
	bne	$a0 $zero label22
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label22:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$s1 0($fp)
	lw	$s2 4($fp)
	b	label15
label21:
	jal	_case_abort
label15:
	la	$a0 str_const4
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	sw	$s1 0($fp)
	bne	$a0 $zero label23
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label23:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$s1 0($fp)
	move	$a0 $s0
	bne	$a0 $zero label25
	la	$a0 str_const0
	li	$t1 1
	jal	_case_abort2
label25:
	lw	$t2 0($a0)
	blt	$t2 8 label26
	bgt	$t2 8 label26
	move	$s1 $a0
	la	$a0 str_const3
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	la	$a0 IO_protObj
	jal	Object.copy
	sw	$s1 0($fp)
	jal	IO_init
	lw	$s1 0($fp)
	sw	$s1 0($fp)
	bne	$a0 $zero label27
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label27:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$s1 0($fp)
	b	label24
label26:
	blt	$t2 3 label28
	bgt	$t2 3 label28
	move	$s1 $a0
	la	$a0 str_const1
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	la	$a0 IO_protObj
	jal	Object.copy
	sw	$s1 0($fp)
	jal	IO_init
	lw	$s1 0($fp)
	sw	$s1 0($fp)
	bne	$a0 $zero label29
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label29:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$s1 0($fp)
	b	label24
label28:
	blt	$t2 1 label30
	bgt	$t2 2 label30
	move	$s1 $a0
	la	$a0 str_const2
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	la	$a0 IO_protObj
	jal	Object.copy
	sw	$s1 0($fp)
	jal	IO_init
	lw	$s1 0($fp)
	sw	$s1 0($fp)
	bne	$a0 $zero label31
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label31:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$s1 0($fp)
	b	label24
label30:
	jal	_case_abort
label24:
	la	$a0 str_const4
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	la	$a0 IO_protObj
	jal	Object.copy
	jal	IO_init
	bne	$a0 $zero label32
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label32:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	la	$a0 Ccc_protObj
	jal	Object.copy
	jal	Ccc_init
	move	$s1 $a0
	move	$a0 $s1
	sw	$s1 0($fp)
	bne	$a0 $zero label33
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label33:
	lw	$t1 8($a0)
	lw	$t1 4($t1)
	jalr		$t1
	lw	$s1 0($fp)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	la	$a0 IO_protObj
	jal	Object.copy
	sw	$s1 0($fp)
	jal	IO_init
	lw	$s1 0($fp)
	sw	$s1 0($fp)
	bne	$a0 $zero label34
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label34:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$s1 0($fp)
	bne	$s1 $zero label36
	la	$a0 str_const0
	li	$t1 1
	jal	_case_abort2
label36:
	lw	$t2 0($s1)
	blt	$t2 8 label37
	bgt	$t2 8 label37
	move	$s2 $s1
	move	$a0 $s2
	sw	$s1 0($fp)
	sw	$s2 4($fp)
	bne	$a0 $zero label38
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label38:
	lw	$t1 8($a0)
	lw	$t1 20($t1)
	jalr		$t1
	lw	$s1 0($fp)
	lw	$s2 4($fp)
	b	label35
label37:
	blt	$t2 3 label39
	bgt	$t2 3 label39
	move	$s2 $s1
	la	$a0 str_const1
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	la	$a0 IO_protObj
	jal	Object.copy
	sw	$s1 0($fp)
	sw	$s2 4($fp)
	jal	IO_init
	lw	$s1 0($fp)
	lw	$s2 4($fp)
	sw	$s1 0($fp)
	sw	$s2 4($fp)
	bne	$a0 $zero label40
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label40:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$s1 0($fp)
	lw	$s2 4($fp)
	b	label35
label39:
	blt	$t2 0 label41
	bgt	$t2 8 label41
	move	$s2 $s1
	la	$a0 str_const2
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	la	$a0 IO_protObj
	jal	Object.copy
	sw	$s1 0($fp)
	sw	$s2 4($fp)
	jal	IO_init
	lw	$s1 0($fp)
	lw	$s2 4($fp)
	sw	$s1 0($fp)
	sw	$s2 4($fp)
	bne	$a0 $zero label42
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label42:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$s1 0($fp)
	lw	$s2 4($fp)
	b	label35
label41:
	jal	_case_abort
label35:
	move	$a0 $s1
	sw	$s1 0($fp)
	bne	$a0 $zero label43
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label43:
	lw	$t1 8($a0)
	lw	$t1 16($t1)
	jalr		$t1
	lw	$s1 0($fp)
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	la	$a0 IO_protObj
	jal	Object.copy
	sw	$s1 0($fp)
	jal	IO_init
	lw	$s1 0($fp)
	sw	$s1 0($fp)
	bne	$a0 $zero label44
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label44:
	lw	$t1 8($a0)
	lw	$t1 16($t1)
	jalr		$t1
	lw	$s1 0($fp)
	la	$a0 str_const4
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	la	$a0 IO_protObj
	jal	Object.copy
	sw	$s1 0($fp)
	jal	IO_init
	lw	$s1 0($fp)
	sw	$s1 0($fp)
	bne	$a0 $zero label45
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label45:
	lw	$t1 8($a0)
	lw	$t1 12($t1)
	jalr		$t1
	lw	$s1 0($fp)
	la	$a0 Int_protObj
	jal	Object.copy
	jal	Int_init
	bne	$a0 $zero label50
	la	$a0 str_const0
	li	$t1 1
	jal	_case_abort2
label50:
	lw	$t2 0($a0)
	blt	$t2 3 label51
	bgt	$t2 3 label51
	move	$s1 $a0
	la	$a0 int_const4
	b	label49
label51:
	blt	$t2 0 label52
	bgt	$t2 8 label52
	move	$s1 $a0
	la	$a0 int_const3
	b	label49
label52:
	jal	_case_abort
label49:
	move	$s1 $a0
	la	$a0 Int_protObj
	jal	Object.copy
	sw	$s1 0($fp)
	jal	Int_init
	lw	$s1 0($fp)
	bne	$a0 $zero label54
	la	$a0 str_const0
	li	$t1 1
	jal	_case_abort2
label54:
	lw	$t2 0($a0)
	blt	$t2 3 label55
	bgt	$t2 3 label55
	move	$s2 $a0
	la	$s3 int_const0
	la	$a0 int_const3
	jal	Object.copy
	lw	$t2 12($a0)
	lw	$t1 12($s3)
	sub	$t1 $t1 $t2
	sw	$t1 12($a0)
	b	label53
label55:
	blt	$t2 0 label56
	bgt	$t2 8 label56
	move	$s2 $a0
	la	$a0 int_const3
	b	label53
label56:
	jal	_case_abort
label53:
	move	$t1 $s1
	move	$t2 $a0
	la	$a0 bool_const1
	beq	$t1 $t2 label48
	la	$a1 bool_const0
	jal	equality_test
label48:
	lw	$t1 12($a0)
	beqz	$t1 label46
	la	$a0 int_const5
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label57
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label57:
	lw	$t1 8($a0)
	lw	$t1 16($t1)
	jalr		$t1
	b	label47
label46:
	la	$a0 int_const6
	sw	$a0 0($sp)
	addiu	$sp $sp -4
	move	$a0 $s0
	bne	$a0 $zero label58
	la	$a0 str_const0
	li	$t1 1
	jal	_dispatch_abort
label58:
	lw	$t1 8($a0)
	lw	$t1 16($t1)
	jalr		$t1
label47:
	lw	$fp 24($sp)
	lw	$s0 20($sp)
	lw	$ra 16($sp)
	addiu	$sp $sp 24
	jr	$ra	
