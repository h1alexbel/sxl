/*
 * SPDX-FileCopyrightText: Copyright (c) 2025 Aliaksei Bialiauski
 * SPDX-License-Identifier: MIT
 */
grammar Sxl;

stylesheet
    : entry template*
    ;
entry
    : match nodename EOL application
    ;
match
    : MATCH SPACE XPATH EOL
    ;
template
    : TEMPLATE tid EOL
    ;
// Template application
application
    : APPLY SPACE tid EOL
    ;
// Template ID
tid
    : NAME tmode?
    ;
nodename
    : LARROW NAME RARROW
    ;
xattr
    : AT NAME
    ;
tmode
    : COLON NAME
    ;
TEMPLATE
    : 'template'
    ;
MATCH
    : 'match'
    ;
APPLY
    : 'apply'
    ;
LARROW
    : '<'
    ;
RARROW
    : '>'
    ;
XPATH
    : '/'? STRING
    ;
AT
    : '@'
    ;
NAME
    : [a-zA-Z_][a-zA-Z0-9_-]*
    ;
STRING
    : '"' ( '\\' . | ~["\\\r\n] )* '"'
    ;
COLON
    : ':'
    ;
SPACE
    : ' '
    ;
EOL
    : LINEBREAK INDENT*
    ;
fragment INDENT
    : SPACE SPACE
    ;
fragment LINEBREAK
    : '\n'
    | '\r\n'
    ;
