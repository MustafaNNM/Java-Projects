#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*Desteklenen bazi karakterler*/
char *yorum_isaretleri[2]= {"{","}"};
/*
yorum   index no
bas     '0'
bitir   '1'
*/
/*Karakterler*/
char letter[52]= {
        'a','b','c','d','e','f','g','h','i','j',
        'k','l','m','n','o','p','q','r','s','t',
        'u','v','w','x','y','z','A','B','C','D',
        'E','F','G','H','I','J','K','L','M','N',
        'O','P','Q','R','S','T','U','V','W','X',
        'Y','Z'
};
/*Sayilar*/
/*Ayni zamanda Karakterler*/
char digit[10]= {
        '0','1','2','3','4','5','6','7','8','9'
};
/*Isaretler*/
char *sign[3]= {"+","-",""};
/*
artý->0
eksi->1
isatersiz->2
*/
char *adding_operator[3]= {"+","-","or"};
/*
artý->0
eksi->1
or->2
*/
char *multiplying_operator[3]= {"*","div","end"};
/*
*->0
div->1
end->2
*/
char *relational_operator[6]= {"= =","<>","<","<=",">=",">"};
/*
operator index_no
= =      '0'
<>       '1'
<        '2'
<=       '3'
>=       '4'
>        '5'
*/
/*Simple types*/
char *integer_or_boolean[2]= {"integer","boolean"};
/*
type    no
integer 0
boolean 1
*/
char *special_symbol[37]= {
        "+","-","*","=","<>",
        "<",">","<=",">=","(",
        ")","[","]",":=",".",
        ",",";",":","..",
        "div","or","and","not",
        "if","then","else","of",
        "while","do","begin","end",
        "read","write","var","array",
        "procedure","program"
};
/*
symbol index no
+      '0'
-      '1'
*      '2'
=      '3'
<>     '4'
<      '5'
>      '6'
<=     '7'
>=     '8'
(      '9'
)      '10'
[      '11'
]      '12'
:=     '13'
.      '14'
,      '15'
;      '16'
:      '17'
..     '18'
div    '19'
or     '20'
and    '21'
not    '22'
if     '23'
then   '24'
else   '25'
of     '26'
while  '27'
do     '28'
begin  '29'
end    '30'
read   '31'
write  '32'
var    '33'
array  '34'
procedure '35'
program   '36'
*/
char *type_of_term[]= {
        "Comment","Empty","Identifier","New_identifier","Integer_constant","Index_range","Simple_type","Array_type","Type","Variable_declaration",
        "New_variable_declaration","Variable_declaration_part","Procedure_declaration","New_procedure_declaration_part","Procedure_declaration_part",
        "Variable_identifier","Entire_variable","Array_variable","Indexed_variable","Variable","Iki_tirnak_arasi","Dort_tirnak","Character_constant",
        "Constant_identifier","Constant","Parantezli_expression","Factor","Carpim_devami","Term","Toplama_devami","Simple_expression","Complex_expression",
        "Expression","Assignment_statement","Procedure_identifier","Procedure_statement","Input_variable","Output_variable","New_input_variable","New_output_variable",
        "Read_statement","Write_statement","Simple_statement","Statement","If_then","If_then_else","If_statement","While_statement","Structured_statement","New_statement",
        "Compound_statement","Statement_part","Block","Program"
};
/*
no type_of_term
0  "Comment"
1  "Empty",
2  "Identifier",
3  "New_identifier",
4  "Integer_constant",
5  "Index_range",
6  "Simple_type",
7  "Array_type",
8  "Type",
9  "Variable_declaration",
10 "New_variable_declaration",
11 "Variable_declaration_part",
12 "Procedure_declaration",
13 "New_procedure_declaration_part",
14 "Procedure_declaration_part",
15 "Variable_identifier",
16 "Entire_variable",
17 "Array_variable",
18 "Indexed_variable",
19 "Variable",
20 "Iki_tirnak_arasi",
21 "Dort_tirnak",
22 "Character_constant",
23 "Constant_identifier",
24 "Constant",
25 "Parantezli_expression",
26 "Factor",
27 "Carpim_devami",
28 "Term",
29 "Toplama_devami",
30 "Simple_expression",
31 "Complex_expression",
32 "Expression",
33 "Assignment_statement",
34 "Procedure_identifier",
35 "Procedure_statement",
36 "Input_variable",
37 "Output_variable",
38 "New_input_variable",
39 "New_output_variable",
40 "Read_statement",
41 "Write_statement",
42 "Simple_statement",
43 "Statement",
44 "If_then",
45 "If_then_else",
46 "If_statement",
47 "While_statement",
48 "Structured_statement",
49 "New_statement",
50 "Compound_statement",
51 "Statement_part",
52 "Block",
53 "Program"
*/
typedef struct comment Comment;
typedef struct empty Empty;
typedef struct identifier Identifier;
typedef struct new_identifier New_identifier;
typedef struct integer_constant Integer_constant;
typedef struct index_range Index_range;
typedef struct simple_type Simple_type;
typedef struct array_type Array_type;
typedef struct type Type;
typedef struct variable_declaration Variable_declaration;
typedef struct new_variable_declaration New_variable_declaration;
typedef struct variable_declaration_part Variable_declaration_part;
typedef struct procedure_declaration Procedure_declaration;
typedef struct new_procedure_declaration_part New_procedure_declaration_part;
typedef struct procedure_declaration_part Procedure_declaration_part;
typedef struct variable_identifier Variable_identifier;
typedef struct entire_variable Entire_variable;
typedef struct array_variable Array_variable;
typedef struct indexed_variable Indexed_variable;
typedef struct variable Variable;
typedef struct iki_tirnak_arasi Iki_tirnak_arasi;
typedef struct dort_tirnak Dort_tirnak;
typedef struct character_constant Character_constant;
typedef struct constant_identifier Constant_identifier;
typedef struct constant Constant;
typedef struct parantezli_expression Parantezli_expression;
typedef struct factor Factor;
typedef struct carpim_devami Carpim_devami;
typedef struct term Term;
typedef struct toplama_devami Toplama_devami;
typedef struct simple_expression Simple_expression;
typedef struct complex_expression Complex_expression;
typedef struct expression Expression;
typedef struct assignment_statement Assignment_statement;
typedef struct procedure_identifier Procedure_identifier;
typedef struct procedure_statement Procedure_statement;
typedef struct input_variable Input_variable;
typedef struct output_variable Output_variable;
typedef struct new_input_variable New_input_variable;
typedef struct new_output_variable New_output_variable;
typedef struct read_statement Read_statement;
typedef struct write_statement Write_statement;
typedef struct simple_statement Simple_statement;
typedef struct statement Statement;
typedef struct if_then If_then;
typedef struct if_then_else If_then_else;
typedef struct if_statement If_statement;
typedef struct while_statement While_statement;
typedef struct structured_statement Structured_statement;
typedef struct new_statement New_statement;
typedef struct compound_statement Compound_statement;
typedef struct statement_part Statement_part;
typedef struct block Block;
typedef struct program Program;

struct satir {
        char letter_digit[127];
};
struct comment {
        int kume_parantez_on;//on=1 -> there is '{' else there isn't
        char *any_character_set;//any character set other than '}'
        int kume_parantez_off;//off=1 -> there is '}' else there isn't
};
struct empty {
        char *empty;
};
struct identifier {
        char *letter_digit;//<identifier> ::= <letter> { <letter or digit> }
};
struct new_identifier {
        Identifier *identifier;
        int index_no_of_virgul;//index no of special_symbol
        New_identifier *new_identifier;
};
struct integer_constant {
        char *digits_constant;
};
struct index_range {
        Integer_constant *integer_constant_min;
        int iki_nokta_yanyana;
        Integer_constant *integer_constant_max;
};
struct simple_type {
        int special_symbol;//index no of special_symbol
};
struct array_type {
        int index_no_of_array;
        int kapali_parantez_acma;
        Index_range *index_range;
        int kapali_parantez_kapama;
        int index_no_of_of;
        Simple_type *simple_type;
};
struct type {
        Simple_type *simple_type;
        Array_type *array_type;
};
struct variable_declaration {
        Identifier *identifier;
        New_identifier *new_identifier;
        int iki_nokta_ust_uste;//index no of special_symbol
        Type *type;
};
struct new_variable_declaration {
        Variable_declaration *variable_declaration;
        int index_no_of_n_virgul;//index no of special_symbol
        New_variable_declaration *new_variable_declaration;
};
struct variable_declaration_part {
        int type;
        Empty *empty;
        int index_no_of_var;//index no of special_symbol
        New_variable_declaration *new_variable_declaration;
};
struct procedure_declaration {
        int index_no_of_procedure;
        Identifier *identifier;
        int index_no_of_n_virgul;
        Block *block;
};
struct new_procedure_declaration_part {
        Procedure_declaration *procedure_declaration;
        int index_no_of_n_virgul;
        New_procedure_declaration_part *new_procedure_declaration_part;
};
struct procedure_declaration_part {
        New_procedure_declaration_part *new_procedure_declaration_part;
};
struct variable_identifier {
        Identifier *identifier;
};
struct entire_variable {
        Variable_identifier *variable_identifier;
};
struct array_variable {
        Entire_variable *entire_variable;
};
struct indexed_variable {
        Array_variable *array_variable;
        int kapali_parantez_on;//index no of special_symbol
        Expression *expression;
        int kapali_parantez_off;//index no of special_symbol
};
struct variable {
        int type;
        Entire_variable *entire_variable;
        Indexed_variable *indexed_variable;
};
struct iki_tirnak_arasi {
        int index_no_of_on;//index no of special_symbol
        char any_character;//any character other than '
        int index_no_of_off;//index no of special_symbol
};
struct dort_tirnak {
        Empty *empty;
};
struct character_constant {
        int type;
        Iki_tirnak_arasi *iki_tirnak_arasi;
        Dort_tirnak *dort_tirnak;
};
struct constant_identifier {
        Identifier *identifier;
};
struct constant {
        int type;
        Integer_constant *integer_constant;
        Character_constant *character_constant;
        Constant_identifier *constant_identifier;
};
struct parantezli_expression {
        int parantez_on;//index no of special_symbol
        Expression *expression;
        int parantez_off;//index no of special_symbol
};
struct factor {
        int type;
        Variable *variable;
        Constant *constant;
        Parantezli_expression *parantezli_expression;
        int index_no_of_not;//index no of special_symbol
        Factor *not_factor;
};
struct carpim_devami {
        int multiplying_operator;
        Factor *factor;
        Carpim_devami *carpim_devami;
};
struct term {
        Factor *factor;
        Carpim_devami *carpim_devami;
};
struct toplama_devami {
        int adding_operator;
        Term *term;
        Toplama_devami *toplama_devami;
};
struct simple_expression {
        int sing_type;
        Term *term;
        Toplama_devami *toplama_devami;
};
struct complex_expression {
        Simple_expression *simple_expression_1;
        int relational_operator_no;
        Simple_expression *simple_expression_2;
};
struct expression {
        int type;
        Simple_expression *simple_expression;
        Complex_expression *complex_expression;
};
struct assignment_statement {
        Variable *variable;
        int index_no_of_define;
        Expression *expression;
};
struct procedure_identifier {
        Identifier *identifier;
};
struct procedure_statement {
        Procedure_identifier *procedure_identifier;
};
struct input_variable {
        Variable *variable;
};
struct output_variable {
        Expression *expression;
};
struct new_input_variable {
        int index_no_of_virgul;
        Input_variable *input_variable;
        New_input_variable *new_input_variable;
};
struct new_output_variable {
        int index_no_of_virgul;
        Output_variable *output_variable;
        New_output_variable *new_output_variable;
};
struct read_statement {
        int index_no_of_read;
        int parantez_on;
        Input_variable *input_variable;
        New_input_variable *new_input_variable;
        int parantez_off;
};
struct write_statement {
        int index_no_of_write;
        int parantez_on;
        Output_variable *output_variable;
        New_output_variable *new_output_variable;
        int parantez_off;
};
struct simple_statement {
        Assignment_statement *assignment_statement;
        Procedure_statement *procedure_statement;
        Read_statement *read_statement;
        Write_statement *write_statement;
};
struct if_then {
        int index_no_of_if;
        Expression *expression;
        int index_no_of_then;
        Statement *statement;
};
struct if_then_else {
        If_then *if_then;
        int index_no_of_else;
        Statement *statement;
};
struct if_statement {
        int type;
        If_then *if_then;
        If_then_else *if_then_else;
};
struct while_statement {
        int index_no_of_while;
        Expression *expression;
        int index_no_of_do;
        Statement *statement;
};
struct structured_statement {
        int type;
        Compound_statement *compound_statement;
        If_statement *if_statement;
        While_statement *while_statement;
};
struct statement {
        int type;
        Simple_statement *simple_statement;
        Structured_statement *structured_statement;
};
struct new_statement {
        int index_no_of_n_virgul;
        Statement *statement;
        New_statement *new_statement;
};
struct compound_statement {
        int index_no_of_begin;
        Statement *statement;
        New_statement *new_statement;
        int index_no_of_end;
};
struct statement_part {
        Compound_statement *compound_statement;
};
struct block {
        Variable_declaration_part *variable_declaration_part;
        Procedure_declaration_part *procedure_declaration_part;
        Statement_part *statement_part;
};
struct program {
        int index_no_of_program;//index no of special_symbol_1=36
        Identifier *identifier;
        int index_no_of_n_virgul;//index no of special_symbol_2
        Block *block;
        int index_no_of_nokta;//index no of special_symbol_3
};

void* create(int index_no);
void* create_by_name(char *type);
void printf_comment(Comment *comment);
void printf_empty(Empty *empty);
void printf_identifier(Identifier *identifier);
void printf_new_identifier(New_identifier *suandaki_new_identifier);
void printf_integer_constant(Integer_constant *integer_constant);
void printf_index_range(Index_range *index_range);
void printf_simple_type(Simple_type *simple_type);
void printf_array_type(Array_type *array_type);
void printf_type(Type *type);
void printf_variable_declaration(Variable_declaration *variable_declaration);
void printf_new_variable_declaration_ptr(New_variable_declaration *suandaki_new_variable_declaration);
void printf_new_variable_declaration(New_variable_declaration *new_variable_declaration);
void printf_variable_declaration_part(Variable_declaration_part *variable_declaration_part);
void printf_procedure_declaration(Procedure_declaration *procedure_declaration);
void printf_new_procedure_declaration_part(New_procedure_declaration_part *new_procedure_declaration_part);
void printf_procedure_declaration_part(Procedure_declaration_part *procedure_declaration_part);
void printf_variable_identifier(Variable_identifier *variable_identifier);
void printf_entire_variable(Entire_variable *entire_variable);
void printf_array_variable(Array_variable *array_variable);
void printf_indexed_variable(Indexed_variable *indexed_variable);
void printf_variable(Variable *variable);
void printf_iki_tirnak_arasi(Iki_tirnak_arasi *iki_tirnak_arasi);
void printf_dort_tirnak(Dort_tirnak *dort_tirnak);
void printf_character_constant(Character_constant *character_constant);
void printf_constant_identifier(Constant_identifier *constant_identifier);
void printf_constant(Constant *constant);
void printf_parantezli_expression(Parantezli_expression *parantezli_expression);
void printf_factor(Factor *factor);
void printf_carpim_devami(Carpim_devami *carpim_devami);
void printf_term(Term *term);
void printf_toplama_devami(Toplama_devami *toplama_devami);
void printf_simple_expression(Simple_expression *simple_expression);
void printf_complex_expression(Complex_expression *complex_expression);
void printf_expression(Expression *expression);
void printf_assignment_statement(Assignment_statement *assignment_statement);
void printf_procedure_identifier(Procedure_identifier *procedure_identifier);
void printf_procedure_statement(Procedure_statement *procedure_statement);
void printf_input_variable(Input_variable *input_variable);
void printf_output_variable(Output_variable *output_variable);
void printf_new_input_variable(New_input_variable *new_input_variable);
void printf_new_output_variable(New_output_variable *new_output_variable);
void printf_read_statement(Read_statement *read_statement);
void printf_write_statement(Write_statement *write_statement);
void printf_simple_statement(Simple_statement *simple_statement);
void printf_if_then(If_then *if_then);
void printf_if_then_else(If_then_else *if_then_else);
void printf_if_statement(If_statement *if_statement);
void printf_while_statement(While_statement *while_statement);
void printf_structured_statement(Structured_statement *structured_statement);
void printf_statement(Statement *statement);
void printf_new_statement(New_statement *new_statement);
void printf_compound_statement(Compound_statement *compound_statement);
void printf_statement_part(Statement_part *statement_part);
void printf_block(Block *block);
void printf_program(Program *program);
char oku(FILE *fptr);
int satir_oku(FILE *fptr,char *b);
int satirlari_oku(FILE *fptr,Identifier *satirlar[]);
void satirlari_yaz(int boyut,Identifier *satirlar[boyut]);

int main()
{
        FILE *fptr;

        char *dosya_adi= "deneme.txt",*amac="r";

        int satir_sayisi=0,x=0,y=5;

        Identifier *satirlar[]= {};

        if ((fptr=fopen(dosya_adi,amac))==NULL) {
                printf("%s acilamadi!\n",dosya_adi);/*Dosya acilamadiginda ekrana mesaj gönderiliyor*/
        }
        /*Dosya acilirsa diger islemler yapilmaktadir*/
        else {
y=126;//pascalda bir satira yazilabilinecek en fazla karakter sayisi
                do {
                        satirlar[x]=create_by_name("Identifier");
                } while(satirlar[x]==NULL);

                do {
                        satirlar[x]->letter_digit=malloc(y);
                } while(satirlar[x]->letter_digit==NULL);

                while(fgets(satirlar[x]->letter_digit,y,fptr) != NULL) {
                        // strip trailing '\n' if it exists
                        int len = strlen(satirlar[x]->letter_digit)-1;
                        if(satirlar[x]->letter_digit[len] == '\n')
                                satirlar[x]->letter_digit[len]=0;
                        printf("\n%s", satirlar[x]->letter_digit);
                        x++;
                        do {
                        satirlar[x]=create_by_name("Identifier");
                } while(satirlar[x]==NULL);

                do {
                        satirlar[x]->letter_digit=malloc(y);
                } while(satirlar[x]->letter_digit==NULL);

                }
        }
        fclose(fptr);
        return 0;
}
void* create(int index_no)
{
        void* nesne;

        do {
                nesne=malloc(sizeof(type_of_term[index_no]));
        } while(nesne==NULL);

        return nesne;
}
void* create_by_name(char *type)
{
        void* nesne;

        do {
                nesne=malloc(sizeof(type));
        } while(nesne==NULL);
        return nesne;
}
void printf_comment(Comment *comment)
{
        if(comment!=NULL) {
                if(comment->kume_parantez_on==0) {
                        printf("\n%s\n",yorum_isaretleri[comment->kume_parantez_on]);
                }
                printf("%s",comment->any_character_set);
                if(comment->kume_parantez_off==1) {
                        printf("\n%s\n",yorum_isaretleri[comment->kume_parantez_off]);
                }
        }
}
void printf_empty(Empty *empty)
{
        if(empty!=NULL) {
                printf("%s",empty->empty);
        }
}
void printf_identifier(Identifier *identifier)
{
        if(identifier!=NULL) {
                printf("%s",identifier->letter_digit);
        }
}
void printf_new_identifier(New_identifier *suandaki_new_identifier)
{
        if(suandaki_new_identifier==NULL) {
                printf("Liste bostur\n");
        } else {
                while(suandaki_new_identifier!=NULL) {
                        printf_identifier(suandaki_new_identifier->identifier);
                        if(suandaki_new_identifier->index_no_of_virgul==16) {
                                printf("%s",special_symbol[suandaki_new_identifier->index_no_of_virgul]);
                        }
                        suandaki_new_identifier=suandaki_new_identifier->new_identifier;
                }
                printf("NULL\n");
        }
}
void printf_integer_constant(Integer_constant *integer_constant)
{
        if(integer_constant!=NULL) {
                printf("%s",integer_constant->digits_constant);
        }
}
void printf_index_range(Index_range *index_range)
{
        if(index_range!=NULL) {
                printf_integer_constant(index_range->integer_constant_min);
                if(index_range->iki_nokta_yanyana==18) {
                        printf("%s",special_symbol[index_range->iki_nokta_yanyana]);
                }
                printf_integer_constant(index_range->integer_constant_max);
        }
}
void printf_simple_type(Simple_type *simple_type)
{
        if(simple_type!=NULL) {
                printf("%s",integer_or_boolean[simple_type->special_symbol]);
        }
}
void printf_array_type(Array_type *array_type)
{
        if(array_type!=NULL) {
                printf("%s",special_symbol[array_type->index_no_of_array]);
                printf("%s",special_symbol[array_type->kapali_parantez_acma]);
                printf_index_range(array_type->index_range);
                printf("%s",special_symbol[array_type->kapali_parantez_kapama]);
                printf("%s",special_symbol[array_type->index_no_of_of]);
                printf_simple_type(array_type->simple_type);
        }
}
void printf_type(Type *type)
{
        if(type!=NULL) {
                printf_simple_type(type->simple_type);
                printf_array_type(type->array_type);
        }
}
void printf_variable_declaration(Variable_declaration *variable_declaration)
{
        if(variable_declaration!=NULL) {
                printf_identifier(variable_declaration->identifier);
                printf_new_identifier(variable_declaration->new_identifier);
                printf("%s",special_symbol[variable_declaration->iki_nokta_ust_uste]);
                printf_type(variable_declaration->type);
        }
}
void printf_new_variable_declaration(New_variable_declaration *suandaki_new_variable_declaration)
{
        if(suandaki_new_variable_declaration==NULL) {
                printf("Liste bostur\n");
        } else {
                while(suandaki_new_variable_declaration!=NULL) {
                        printf_variable_declaration(suandaki_new_variable_declaration->variable_declaration);
                        if(suandaki_new_variable_declaration->index_no_of_n_virgul==16) {
                                printf("%s",special_symbol[suandaki_new_variable_declaration->index_no_of_n_virgul]);
                        }
                        suandaki_new_variable_declaration=suandaki_new_variable_declaration->new_variable_declaration;
                }
                printf("NULL\n");
        }
}
void printf_variable_declaration_part(Variable_declaration_part *variable_declaration_part)
{
        if(variable_declaration_part!=NULL) {
                if(variable_declaration_part->type==0) {
                        printf_empty(variable_declaration_part->empty);
                } else {
                        printf("%s",special_symbol[variable_declaration_part->index_no_of_var]);
                        printf_new_variable_declaration(variable_declaration_part->new_variable_declaration);
                }
        }
}
void printf_procedure_declaration(Procedure_declaration *procedure_declaration)
{
        if(procedure_declaration!=NULL) {
                printf("%s",special_symbol[procedure_declaration->index_no_of_n_virgul]);
                printf_identifier(procedure_declaration->identifier);
                printf("%s",special_symbol[procedure_declaration->index_no_of_procedure]);
                printf_block(procedure_declaration->block);
        }
}
void printf_new_procedure_declaration_part(New_procedure_declaration_part *new_procedure_declaration_part)
{
        while(new_procedure_declaration_part!=NULL) {
                printf_procedure_declaration(new_procedure_declaration_part->procedure_declaration);
                if(new_procedure_declaration_part->index_no_of_n_virgul==16) {
                        printf("%s",special_symbol[new_procedure_declaration_part->index_no_of_n_virgul]);
                }
                new_procedure_declaration_part=new_procedure_declaration_part->new_procedure_declaration_part;
        }
}
void printf_procedure_declaration_part(Procedure_declaration_part *procedure_declaration_part)
{
        if(procedure_declaration_part!=NULL) {
                printf_new_procedure_declaration_part(procedure_declaration_part->new_procedure_declaration_part);
        }
}
void printf_variable_identifier(Variable_identifier *variable_identifier)
{
        if(variable_identifier!=NULL) {
                printf_identifier(variable_identifier->identifier);
        }
}
void printf_entire_variable(Entire_variable *entire_variable)
{
        if(entire_variable!=NULL) {
                printf_variable_identifier(entire_variable->variable_identifier);
        }
}
void printf_array_variable(Array_variable *array_variable)
{
        if(array_variable!=NULL) {
                printf_entire_variable(array_variable->entire_variable);
        }
}
void printf_indexed_variable(Indexed_variable *indexed_variable)
{
        if(indexed_variable!=NULL) {
                printf_array_variable(indexed_variable->array_variable);
                if(indexed_variable->kapali_parantez_on==11) {
                        printf("%s",special_symbol[indexed_variable->kapali_parantez_on]);
                }
                printf_expression(indexed_variable->expression);
                if(indexed_variable->kapali_parantez_off==12) {
                        printf("%s",special_symbol[indexed_variable->kapali_parantez_off]);
                }

        }
}
void printf_variable(Variable *variable)
{
        if(variable!=NULL) {
                if(variable->type) {
                        printf_entire_variable(variable->entire_variable);
                } else {
                        printf_indexed_variable(variable->indexed_variable);
                }
        }
}
void printf_iki_tirnak_arasi(Iki_tirnak_arasi *iki_tirnak_arasi)
{
        if(iki_tirnak_arasi!=NULL) {
                if(iki_tirnak_arasi->index_no_of_on==2) {
                        printf("%s",yorum_isaretleri[iki_tirnak_arasi->index_no_of_on]);
                }
                printf("%c",iki_tirnak_arasi->any_character);
                if(iki_tirnak_arasi->index_no_of_off==2) {
                        printf("%s",yorum_isaretleri[iki_tirnak_arasi->index_no_of_off]);
                }
        }
}
void printf_dort_tirnak(Dort_tirnak *dort_tirnak)
{
        if(dort_tirnak!=NULL) {
                printf_empty(dort_tirnak->empty);
        }
}
void printf_character_constant(Character_constant *character_constant)
{
        if(character_constant!=NULL) {
                if(character_constant->type) {
                        printf_iki_tirnak_arasi(character_constant->iki_tirnak_arasi);
                } else {
                        printf_dort_tirnak(character_constant->dort_tirnak);
                }
        }
}
void printf_constant_identifier(Constant_identifier *constant_identifier)
{
        if(constant_identifier!=NULL) {
                printf_identifier(constant_identifier->identifier);
        }
}
void printf_constant(Constant *constant)
{
        if(constant!=NULL) {
                switch(constant->type) {
                case 0:
                        printf_integer_constant(constant->integer_constant);
                        break;
                case 1:
                        printf_character_constant(constant->character_constant);
                        break;
                case 2:
                        printf_constant_identifier(constant->constant_identifier);
                        break;
                }
        }
}
void printf_parantezli_expression(Parantezli_expression *parantezli_expression)
{
        if(parantezli_expression!=NULL) {
                if(parantezli_expression->parantez_on==9) {
                        printf("%s",special_symbol[parantezli_expression->parantez_on]);
                }
                printf_expression(parantezli_expression->expression);
                if(parantezli_expression->parantez_off==10) {
                        printf("%s",special_symbol[parantezli_expression->parantez_off]);
                }
        }
}
void printf_factor(Factor *factor)
{
        if(factor!=NULL) {
                switch(factor->type) {
                case 0:
                        printf_variable(factor->variable);
                        break;
                case 1:
                        printf_constant(factor->constant);
                        break;
                case 2:
                        printf_parantezli_expression(factor->parantezli_expression);
                        break;
                case 3:
                        if(factor->index_no_of_not==10) {
                                printf("%s",special_symbol[factor->index_no_of_not]);
                        }
                        printf_factor(factor->not_factor);
                        break;
                }
        }
}
void printf_carpim_devami(Carpim_devami *carpim_devami)
{
        while(carpim_devami!=NULL) {
                printf_factor(carpim_devami->factor);
                if(carpim_devami->multiplying_operator==0||carpim_devami->multiplying_operator==1||carpim_devami->multiplying_operator==2) {
                        printf("%s",multiplying_operator[carpim_devami->multiplying_operator]);
                }
                carpim_devami=carpim_devami->carpim_devami;
        }
}
void printf_term(Term *term)
{
        if(term!=NULL) {
                printf_factor(term->factor);
                printf_carpim_devami(term->carpim_devami);
        }
}
void printf_toplama_devami(Toplama_devami *toplama_devami)
{
        while(toplama_devami!=NULL) {
                printf_term(toplama_devami->term);
                if(toplama_devami->adding_operator==0||toplama_devami->adding_operator==1||toplama_devami->adding_operator==2) {
                        printf("%s",adding_operator[toplama_devami->adding_operator]);
                }
                toplama_devami=toplama_devami->toplama_devami;
        }
}
void printf_simple_expression(Simple_expression *simple_expression)
{
        if(simple_expression!=NULL) {
                if(simple_expression->sing_type==0||simple_expression->sing_type==1) {
                        printf("%s",sign[simple_expression->sing_type]);
                }
                printf_term(simple_expression->term);
                printf_toplama_devami(simple_expression->toplama_devami);
        }
}
void printf_complex_expression(Complex_expression *complex_expression)
{
        if(complex_expression!=NULL) {
                printf_simple_expression(complex_expression->simple_expression_1);
                if(complex_expression->relational_operator_no>-1&&complex_expression->relational_operator_no<6) {
                        printf("%s",relational_operator[complex_expression->relational_operator_no]);
                }
                printf_simple_expression(complex_expression->simple_expression_2);
        }
}
void printf_expression(Expression *expression)
{
        if(expression!=NULL) {
                if(expression->type) {
                        printf_simple_expression(expression->simple_expression);
                } else {
                        printf_complex_expression(expression->complex_expression);
                }
        }
}
void printf_assignment_statement(Assignment_statement *assignment_statement)
{
        if(assignment_statement!=NULL) {
                printf_variable(assignment_statement->variable);
                if(assignment_statement->index_no_of_define==13) {
                        printf("%s",special_symbol[assignment_statement->index_no_of_define]);
                }
                printf_expression(assignment_statement->expression);
        }
}
void printf_procedure_identifier(Procedure_identifier *procedure_identifier)
{
        if(procedure_identifier!=NULL) {
                printf_identifier(procedure_identifier->identifier);
        }
}
void printf_procedure_statement(Procedure_statement *procedure_statement)
{
        if(procedure_statement!=NULL) {
                printf_procedure_identifier(procedure_statement->procedure_identifier);
        }
}
void printf_input_variable(Input_variable *input_variable)
{
        if(input_variable!=NULL) {
                printf_variable(input_variable->variable);
        }
}
void printf_output_variable(Output_variable *output_variable)
{
        if(output_variable!=NULL) {
                printf_expression(output_variable->expression);
        }
}
void printf_new_input_variable(New_input_variable *new_input_variable)
{
        while(new_input_variable!=NULL) {
                printf_input_variable(new_input_variable->input_variable);
                if(new_input_variable->index_no_of_virgul==16) {
                        printf("%s",special_symbol[new_input_variable->index_no_of_virgul]);
                }
                new_input_variable=new_input_variable->new_input_variable;
        }
}
void printf_new_output_variable(New_output_variable *new_output_variable)
{
        while(new_output_variable!=NULL) {
                printf_output_variable(new_output_variable->output_variable);
                if(new_output_variable->index_no_of_virgul==16) {
                        printf("%s",special_symbol[new_output_variable->index_no_of_virgul]);
                }
                new_output_variable=new_output_variable->new_output_variable;
        }
}
void printf_read_statement(Read_statement *read_statement)
{
        if(read_statement!=NULL) {
                if(read_statement->index_no_of_read==31) {
                        printf("%s",special_symbol[read_statement->index_no_of_read]);
                }
                if(read_statement->parantez_on==9) {
                        printf("%s",special_symbol[read_statement->parantez_on]);
                }
                printf_input_variable(read_statement->input_variable);
                printf_new_input_variable(read_statement->new_input_variable);
                if(read_statement->parantez_off==10) {
                        printf("%s",special_symbol[read_statement->parantez_off]);
                }
        }
}
void printf_write_statement(Write_statement *write_statement)
{
        if(write_statement!=NULL) {
                if(write_statement->index_no_of_write==32) {
                        printf("%s",special_symbol[write_statement->index_no_of_write]);
                }
                if(write_statement->parantez_on==9) {
                        printf("%s",special_symbol[write_statement->parantez_on]);
                }
                printf_output_variable(write_statement->output_variable);
                printf_new_output_variable(write_statement->new_output_variable);
                if(write_statement->parantez_off==10) {
                        printf("%s",special_symbol[write_statement->parantez_off]);
                }
        }
}
void printf_simple_statement(Simple_statement *simple_statement)
{
        if(simple_statement!=NULL) {
                printf_assignment_statement(simple_statement->assignment_statement);
                printf_procedure_statement(simple_statement->procedure_statement);
                printf_read_statement(simple_statement->read_statement);
                printf_write_statement(simple_statement->write_statement);
        }
}
void printf_if_then(If_then *if_then)
{
        if(if_then!=NULL) {
                if(if_then->index_no_of_if==23) {
                        printf("%s",special_symbol[if_then->index_no_of_if]);
                }
                printf_expression(if_then->expression);
                if(if_then->index_no_of_then==24) {
                        printf("%s",special_symbol[if_then->index_no_of_then]);
                }
                printf_statement(if_then->statement);
        }
}
void printf_if_then_else(If_then_else *if_then_else)
{
        if(if_then_else!=NULL) {
                printf_if_then(if_then_else->if_then);
                if(if_then_else->index_no_of_else==25) {
                        printf("%s",special_symbol[if_then_else->index_no_of_else]);
                }
                printf_statement(if_then_else->statement);
        }
}
void printf_if_statement(If_statement *if_statement)
{
        if(if_statement!=NULL) {
                if(if_statement->type) {
                        printf_if_then(if_statement->if_then);
                } else {
                        printf_if_then_else(if_statement->if_then_else);
                }
        }
}
void printf_while_statement(While_statement *while_statement)
{
        if(while_statement!=NULL) {
                if(while_statement->index_no_of_while==27) {
                        printf("%s",special_symbol[while_statement->index_no_of_while]);
                }
                printf_expression(while_statement->expression);
                if(while_statement->index_no_of_do==25) {
                        printf("%s",special_symbol[while_statement->index_no_of_do]);
                }
                printf_statement(while_statement->statement);
        }
}
void printf_structured_statement(Structured_statement *structured_statement)
{
        if(structured_statement!=NULL) {
                switch(structured_statement->type) {
                case 0:
                        printf_compound_statement(structured_statement->compound_statement);
                        break;
                case 1:
                        printf_if_statement(structured_statement->if_statement);
                        break;
                case 2:
                        printf_while_statement(structured_statement->while_statement);
                        break;
                }
        }
}
void printf_statement(Statement *statement)
{
        if(statement!=NULL) {
                if(statement->type) {
                        printf_structured_statement(statement->structured_statement);
                }
        }
}
void printf_new_statement(New_statement *new_statement)
{
        while(new_statement!=NULL) {
                if(new_statement->index_no_of_n_virgul==16) {
                        printf("%s",special_symbol[new_statement->index_no_of_n_virgul]);
                }
                printf_statement(new_statement->statement);
                new_statement=new_statement->new_statement;
        }
}
void printf_compound_statement(Compound_statement *compound_statement)
{
        if(compound_statement!=NULL) {
                if(compound_statement->index_no_of_begin==29) {
                        printf("%s",special_symbol[compound_statement->index_no_of_begin]);
                }
                printf_statement(compound_statement->statement);
                printf_new_statement(compound_statement->new_statement);
                if(compound_statement->index_no_of_end==30) {
                        printf("%s",special_symbol[compound_statement->index_no_of_end]);
                }
        }
}
void printf_statement_part(Statement_part *statement_part)
{
        if(statement_part!=NULL) {
                printf_compound_statement(statement_part->compound_statement);
        }
}
void printf_block(Block *block)
{
        if(block!=NULL) {
                printf_variable_declaration_part(block->variable_declaration_part);
                printf_procedure_declaration_part(block->procedure_declaration_part);
                printf_statement_part(block->statement_part);
        }
}
void printf_program(Program *program)
{
        if(program!=NULL) {
                if(program->index_no_of_program==36) {
                        printf("%s",special_symbol[program->index_no_of_program]);
                }
                printf_identifier(program->identifier);
                if(program->index_no_of_n_virgul==16) {
                        printf("%s",special_symbol[program->index_no_of_n_virgul]);
                }
                printf_block(program->block);
                if(program->index_no_of_nokta==14) {
                        printf("%s",special_symbol[program->index_no_of_nokta]);
                }
        }
}
char oku(FILE *fptr)
{
        char harf;
        fscanf(fptr,"%c",&harf);
        fflush(stdin);
        return harf;
}
int satir_oku(FILE *fptr,char *b)
{
        int x=0;
        //char a='a';

        //fscanf(fptr,"%c",&b[x]);
        b[x]=fgetc(fptr);
        printf("%c\n",b[x]);
        while((!feof(fptr))&&(b[x]!='\n')) {
                //printf("%c",a);
                //b[x++]=a;
                //fscanf(fptr,"%c",&b[++x]);
                b[++x]=fgetc(fptr);
                fflush(stdin);
                printf("%c\n",b[x]);
        }
        b[x]='\0';
        fflush(stdin);
        printf("x:%d",x);
        return x;
}
int satirlari_oku(FILE *fptr,Identifier *satirlar[])
{
        int x=0;
        int uzunluk=0;

        do {
                satirlar[x]=malloc(sizeof(Identifier));
        } while(satirlar[x]==NULL);

        do {
                satirlar[x]->letter_digit=malloc(sizeof(127));
        } while(satirlar[x]->letter_digit==NULL);

        fgets(satirlar[x]->letter_digit,126,fptr);
        printf_identifier(satirlar[x]);
        satirlar[x]->letter_digit[126]='\n';
        printf("ilk satir okundu\n");
        while(!feof(fptr)) {
                x++;
                printf("%d\n",x);
                do {
                        satirlar[x]=malloc(sizeof(Identifier));
                } while(satirlar[x]==NULL);

                do {
                        satirlar[x]->letter_digit=malloc(sizeof(127));
                } while(satirlar[x]->letter_digit==NULL);
                fgets(satirlar[x]->letter_digit,126,fptr);
                satirlar[x]->letter_digit[126]='\n';
                printf_identifier(satirlar[x]);
        }
        printf("satir sayisi fonk icinde:%d\n",x);
        return x;
}
void satirlari_yaz(int boyut,Identifier *satirlar[boyut])
{
        int i;
        for(i=0; i<boyut; i++) {
                printf_identifier(satirlar[i]);
                printf("\n");
        }
}
