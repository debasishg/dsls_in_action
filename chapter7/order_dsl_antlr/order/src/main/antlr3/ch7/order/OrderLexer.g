lexer grammar OrderLexer;

  
@lexer::header {
    package ch7.order;
}


EQ   : '=';
BUY  : 'buy';
SELL : 'sell';
AT   : '@';
FOR  : 'for';
LPRICE  : 'limitprice';
ID      : ('a'..'z'|'A'..'Z')+;
INT     : '0'..'9'+;
NEWLINE : '\r'? '\n';
WS      : (' '|'\t')+ {skip();};
