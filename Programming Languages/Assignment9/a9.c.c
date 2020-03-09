#include <setjmp.h>
#include <assert.h>
#include <stdlib.h>
#include <stdio.h>
#include "a9.h"

void *ktr_emptyr__m__k(void *dismount) {
kt* _data = (kt*)malloc(sizeof(kt));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _emptyr__m__k_kt;
  _data->u._emptyr__m__k._dismount = dismount;
  return (void *)_data;
}

void *ktr_innerr__m__multr__m__k(void *vr1r__ex__, void *kr__ex__) {
kt* _data = (kt*)malloc(sizeof(kt));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _innerr__m__multr__m__k_kt;
  _data->u._innerr__m__multr__m__k._vr1r__ex__ = vr1r__ex__;
  _data->u._innerr__m__multr__m__k._kr__ex__ = kr__ex__;
  return (void *)_data;
}

void *ktr_outerr__m__multr__m__k(void *xr2r__ex__, void *envr__ex__, void *kr__ex__) {
kt* _data = (kt*)malloc(sizeof(kt));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _outerr__m__multr__m__k_kt;
  _data->u._outerr__m__multr__m__k._xr2r__ex__ = xr2r__ex__;
  _data->u._outerr__m__multr__m__k._envr__ex__ = envr__ex__;
  _data->u._outerr__m__multr__m__k._kr__ex__ = kr__ex__;
  return (void *)_data;
}

void *ktr_subr1r__m__k(void *kr__ex__) {
kt* _data = (kt*)malloc(sizeof(kt));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _subr1r__m__k_kt;
  _data->u._subr1r__m__k._kr__ex__ = kr__ex__;
  return (void *)_data;
}

void *ktr_zeror__m__k(void *kr__ex__) {
kt* _data = (kt*)malloc(sizeof(kt));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _zeror__m__k_kt;
  _data->u._zeror__m__k._kr__ex__ = kr__ex__;
  return (void *)_data;
}

void *ktr_ifr__m__k(void *conseqr__ex__, void *altr__ex__, void *envr__ex__, void *kr__ex__) {
kt* _data = (kt*)malloc(sizeof(kt));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _ifr__m__k_kt;
  _data->u._ifr__m__k._conseqr__ex__ = conseqr__ex__;
  _data->u._ifr__m__k._altr__ex__ = altr__ex__;
  _data->u._ifr__m__k._envr__ex__ = envr__ex__;
  _data->u._ifr__m__k._kr__ex__ = kr__ex__;
  return (void *)_data;
}

void *ktr_throwr__m__innerr__m__k(void *vvr__ex__) {
kt* _data = (kt*)malloc(sizeof(kt));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _throwr__m__innerr__m__k_kt;
  _data->u._throwr__m__innerr__m__k._vvr__ex__ = vvr__ex__;
  return (void *)_data;
}

void *ktr_throwr__m__outerr__m__k(void *kr__m__expr__ex__, void *envr__ex__) {
kt* _data = (kt*)malloc(sizeof(kt));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _throwr__m__outerr__m__k_kt;
  _data->u._throwr__m__outerr__m__k._kr__m__expr__ex__ = kr__m__expr__ex__;
  _data->u._throwr__m__outerr__m__k._envr__ex__ = envr__ex__;
  return (void *)_data;
}

void *ktr_letr__m__k(void *bodyr__ex__, void *envr__ex__, void *kr__ex__) {
kt* _data = (kt*)malloc(sizeof(kt));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _letr__m__k_kt;
  _data->u._letr__m__k._bodyr__ex__ = bodyr__ex__;
  _data->u._letr__m__k._envr__ex__ = envr__ex__;
  _data->u._letr__m__k._kr__ex__ = kr__ex__;
  return (void *)_data;
}

void *ktr_appr__m__innerr__m__k(void *clor__ex__, void *kr__ex__) {
kt* _data = (kt*)malloc(sizeof(kt));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _appr__m__innerr__m__k_kt;
  _data->u._appr__m__innerr__m__k._clor__ex__ = clor__ex__;
  _data->u._appr__m__innerr__m__k._kr__ex__ = kr__ex__;
  return (void *)_data;
}

void *ktr_appr__m__outerr__m__k(void *randr__ex__, void *envr__ex__, void *kr__ex__) {
kt* _data = (kt*)malloc(sizeof(kt));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _appr__m__outerr__m__k_kt;
  _data->u._appr__m__outerr__m__k._randr__ex__ = randr__ex__;
  _data->u._appr__m__outerr__m__k._envr__ex__ = envr__ex__;
  _data->u._appr__m__outerr__m__k._kr__ex__ = kr__ex__;
  return (void *)_data;
}

void *closr_maker__m__closure(void *body, void *env) {
clos* _data = (clos*)malloc(sizeof(clos));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _maker__m__closure_clos;
  _data->u._maker__m__closure._body = body;
  _data->u._maker__m__closure._env = env;
  return (void *)_data;
}

void *envmtr_extendr__m__env(void *ar__ex__, void *envr__ex__) {
envmt* _data = (envmt*)malloc(sizeof(envmt));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _extendr__m__env_envmt;
  _data->u._extendr__m__env._ar__ex__ = ar__ex__;
  _data->u._extendr__m__env._envr__ex__ = envr__ex__;
  return (void *)_data;
}

void *envmtr_emptyr__m__env() {
envmt* _data = (envmt*)malloc(sizeof(envmt));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _emptyr__m__env_envmt;
  return (void *)_data;
}

void *exprr_const(void *cexp) {
expr* _data = (expr*)malloc(sizeof(expr));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _const_expr;
  _data->u._const._cexp = cexp;
  return (void *)_data;
}

void *exprr_var(void *n) {
expr* _data = (expr*)malloc(sizeof(expr));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _var_expr;
  _data->u._var._n = n;
  return (void *)_data;
}

void *exprr_if(void *test, void *conseq, void *alt) {
expr* _data = (expr*)malloc(sizeof(expr));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _if_expr;
  _data->u._if._test = test;
  _data->u._if._conseq = conseq;
  _data->u._if._alt = alt;
  return (void *)_data;
}

void *exprr_mult(void *nexpr1, void *nexpr2) {
expr* _data = (expr*)malloc(sizeof(expr));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _mult_expr;
  _data->u._mult._nexpr1 = nexpr1;
  _data->u._mult._nexpr2 = nexpr2;
  return (void *)_data;
}

void *exprr_subr1(void *nexp) {
expr* _data = (expr*)malloc(sizeof(expr));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _subr1_expr;
  _data->u._subr1._nexp = nexp;
  return (void *)_data;
}

void *exprr_zero(void *nexp) {
expr* _data = (expr*)malloc(sizeof(expr));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _zero_expr;
  _data->u._zero._nexp = nexp;
  return (void *)_data;
}

void *exprr_letcc(void *body) {
expr* _data = (expr*)malloc(sizeof(expr));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _letcc_expr;
  _data->u._letcc._body = body;
  return (void *)_data;
}

void *exprr_throw(void *kexp, void *vexp) {
expr* _data = (expr*)malloc(sizeof(expr));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _throw_expr;
  _data->u._throw._kexp = kexp;
  _data->u._throw._vexp = vexp;
  return (void *)_data;
}

void *exprr_let(void *exp, void *body) {
expr* _data = (expr*)malloc(sizeof(expr));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _let_expr;
  _data->u._let._exp = exp;
  _data->u._let._body = body;
  return (void *)_data;
}

void *exprr_lambda(void *body) {
expr* _data = (expr*)malloc(sizeof(expr));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _lambda_expr;
  _data->u._lambda._body = body;
  return (void *)_data;
}

void *exprr_app(void *rator, void *rand) {
expr* _data = (expr*)malloc(sizeof(expr));
if(!_data) {
  fprintf(stderr, "Out of memory\n");
  exit(1);
}
  _data->tag = _app_expr;
  _data->u._app._rator = rator;
  _data->u._app._rand = rand;
  return (void *)_data;
}

int main()
{
valuer__m__ofr__m__exp = (void *)exprr_let(exprr_lambda(exprr_lambda(exprr_if(exprr_zero(exprr_var((void *)0)),exprr_const((void *)1),exprr_mult(exprr_var((void *)0),exprr_app(exprr_app(exprr_var((void *)1),exprr_var((void *)1)),exprr_subr1(exprr_var((void *)0))))))),exprr_mult(exprr_letcc(exprr_app(exprr_app(exprr_var((void *)1),exprr_var((void *)1)),exprr_throw(exprr_var((void *)0),exprr_app(exprr_app(exprr_var((void *)1),exprr_var((void *)1)),exprr_const((void *)4))))),exprr_const((void *)5)));
valuer__m__ofr__m__env = (void *)envmtr_emptyr__m__env();
pc = &valuer__m__ofr__m__cps;
mount_tram();
printf("Fact 5: %d\n", (int)applyr__m__kr__m__v);}

void applyr__m__k()
{
kt* _c = (kt*)applyr__m__kr__m__k;
switch (_c->tag) {
case _emptyr__m__k_kt: {
void *dismount = _c->u._emptyr__m__k._dismount;
_trstr *trstr = (_trstr *)dismount;
longjmp(*trstr->jmpbuf, 1);
break; }
case _innerr__m__multr__m__k_kt: {
void *vr1r__ex__ = _c->u._innerr__m__multr__m__k._vr1r__ex__;
void *kr__ex__ = _c->u._innerr__m__multr__m__k._kr__ex__;
applyr__m__kr__m__k = (void *)kr__ex__;
applyr__m__kr__m__v = (void *)(void *)((int)vr1r__ex__ * (int)applyr__m__kr__m__v);
pc = &applyr__m__k;
break; }
case _outerr__m__multr__m__k_kt: {
void *xr2r__ex__ = _c->u._outerr__m__multr__m__k._xr2r__ex__;
void *envr__ex__ = _c->u._outerr__m__multr__m__k._envr__ex__;
void *kr__ex__ = _c->u._outerr__m__multr__m__k._kr__ex__;
valuer__m__ofr__m__k = (void *)ktr_innerr__m__multr__m__k(applyr__m__kr__m__v,kr__ex__);
valuer__m__ofr__m__exp = (void *)xr2r__ex__;
valuer__m__ofr__m__env = (void *)envr__ex__;
pc = &valuer__m__ofr__m__cps;
break; }
case _subr1r__m__k_kt: {
void *kr__ex__ = _c->u._subr1r__m__k._kr__ex__;
applyr__m__kr__m__k = (void *)kr__ex__;
applyr__m__kr__m__v = (void *)(void *)((int)applyr__m__kr__m__v - 1);
pc = &applyr__m__k;
break; }
case _zeror__m__k_kt: {
void *kr__ex__ = _c->u._zeror__m__k._kr__ex__;
applyr__m__kr__m__k = (void *)kr__ex__;
applyr__m__kr__m__v = (void *)(applyr__m__kr__m__v == 0);
pc = &applyr__m__k;
break; }
case _ifr__m__k_kt: {
void *conseqr__ex__ = _c->u._ifr__m__k._conseqr__ex__;
void *altr__ex__ = _c->u._ifr__m__k._altr__ex__;
void *envr__ex__ = _c->u._ifr__m__k._envr__ex__;
void *kr__ex__ = _c->u._ifr__m__k._kr__ex__;
if(applyr__m__kr__m__v) {
  valuer__m__ofr__m__k = (void *)kr__ex__;
valuer__m__ofr__m__exp = (void *)conseqr__ex__;
valuer__m__ofr__m__env = (void *)envr__ex__;
pc = &valuer__m__ofr__m__cps;

} else {
  valuer__m__ofr__m__k = (void *)kr__ex__;
valuer__m__ofr__m__exp = (void *)altr__ex__;
valuer__m__ofr__m__env = (void *)envr__ex__;
pc = &valuer__m__ofr__m__cps;

}
break; }
case _throwr__m__innerr__m__k_kt: {
void *vvr__ex__ = _c->u._throwr__m__innerr__m__k._vvr__ex__;
applyr__m__kr__m__k = (void *)applyr__m__kr__m__v;
applyr__m__kr__m__v = (void *)vvr__ex__;
pc = &applyr__m__k;
break; }
case _throwr__m__outerr__m__k_kt: {
void *kr__m__expr__ex__ = _c->u._throwr__m__outerr__m__k._kr__m__expr__ex__;
void *envr__ex__ = _c->u._throwr__m__outerr__m__k._envr__ex__;
valuer__m__ofr__m__k = (void *)ktr_throwr__m__innerr__m__k(applyr__m__kr__m__v);
valuer__m__ofr__m__exp = (void *)kr__m__expr__ex__;
valuer__m__ofr__m__env = (void *)envr__ex__;
pc = &valuer__m__ofr__m__cps;
break; }
case _letr__m__k_kt: {
void *bodyr__ex__ = _c->u._letr__m__k._bodyr__ex__;
void *envr__ex__ = _c->u._letr__m__k._envr__ex__;
void *kr__ex__ = _c->u._letr__m__k._kr__ex__;
valuer__m__ofr__m__k = (void *)kr__ex__;
valuer__m__ofr__m__exp = (void *)bodyr__ex__;
valuer__m__ofr__m__env = (void *)envmtr_extendr__m__env(applyr__m__kr__m__v,envr__ex__);
pc = &valuer__m__ofr__m__cps;
break; }
case _appr__m__innerr__m__k_kt: {
void *clor__ex__ = _c->u._appr__m__innerr__m__k._clor__ex__;
void *kr__ex__ = _c->u._appr__m__innerr__m__k._kr__ex__;
applyr__m__clor__m__k = (void *)kr__ex__;
applyr__m__clor__m__clo = (void *)clor__ex__;
applyr__m__clor__m__arg = (void *)applyr__m__kr__m__v;
pc = &applyr__m__closure;
break; }
case _appr__m__outerr__m__k_kt: {
void *randr__ex__ = _c->u._appr__m__outerr__m__k._randr__ex__;
void *envr__ex__ = _c->u._appr__m__outerr__m__k._envr__ex__;
void *kr__ex__ = _c->u._appr__m__outerr__m__k._kr__ex__;
valuer__m__ofr__m__k = (void *)ktr_appr__m__innerr__m__k(applyr__m__kr__m__v,kr__ex__);
valuer__m__ofr__m__exp = (void *)randr__ex__;
valuer__m__ofr__m__env = (void *)envr__ex__;
pc = &valuer__m__ofr__m__cps;
break; }
}
}

void applyr__m__closure()
{
clos* _c = (clos*)applyr__m__clor__m__clo;
switch (_c->tag) {
case _maker__m__closure_clos: {
void *body = _c->u._maker__m__closure._body;
void *env = _c->u._maker__m__closure._env;
valuer__m__ofr__m__k = (void *)applyr__m__clor__m__k;
valuer__m__ofr__m__exp = (void *)body;
valuer__m__ofr__m__env = (void *)envmtr_extendr__m__env(applyr__m__clor__m__arg,env);
pc = &valuer__m__ofr__m__cps;
break; }
}
}

void applyr__m__env()
{
envmt* _c = (envmt*)applyr__m__envr__m__env;
switch (_c->tag) {
case _emptyr__m__env_envmt: {
fprintf(stderr, "identifier");
 exit(1);
break; }
case _extendr__m__env_envmt: {
void *ar__ex__ = _c->u._extendr__m__env._ar__ex__;
void *envr__ex__ = _c->u._extendr__m__env._envr__ex__;
if((applyr__m__envr__m__y == 0)) {
  applyr__m__kr__m__k = (void *)applyr__m__envr__m__k;
applyr__m__kr__m__v = (void *)ar__ex__;
pc = &applyr__m__k;

} else {
  applyr__m__envr__m__env = (void *)envr__ex__;
applyr__m__envr__m__y = (void *)(void *)((int)applyr__m__envr__m__y - 1);
pc = &applyr__m__env;

}
break; }
}
}

void valuer__m__ofr__m__cps()
{
expr* _c = (expr*)valuer__m__ofr__m__exp;
switch (_c->tag) {
case _const_expr: {
void *exprs = _c->u._const._cexp;
applyr__m__kr__m__k = (void *)valuer__m__ofr__m__k;
applyr__m__kr__m__v = (void *)exprs;
pc = &applyr__m__k;
break; }
case _mult_expr: {
void *xr1 = _c->u._mult._nexpr1;
void *xr2 = _c->u._mult._nexpr2;
valuer__m__ofr__m__k = (void *)ktr_outerr__m__multr__m__k(xr2,valuer__m__ofr__m__env,valuer__m__ofr__m__k);
valuer__m__ofr__m__exp = (void *)xr1;
pc = &valuer__m__ofr__m__cps;
break; }
case _subr1_expr: {
void *x = _c->u._subr1._nexp;
valuer__m__ofr__m__k = (void *)ktr_subr1r__m__k(valuer__m__ofr__m__k);
valuer__m__ofr__m__exp = (void *)x;
pc = &valuer__m__ofr__m__cps;
break; }
case _zero_expr: {
void *x = _c->u._zero._nexp;
valuer__m__ofr__m__k = (void *)ktr_zeror__m__k(valuer__m__ofr__m__k);
valuer__m__ofr__m__exp = (void *)x;
pc = &valuer__m__ofr__m__cps;
break; }
case _if_expr: {
void *test = _c->u._if._test;
void *conseq = _c->u._if._conseq;
void *alt = _c->u._if._alt;
valuer__m__ofr__m__k = (void *)ktr_ifr__m__k(conseq,alt,valuer__m__ofr__m__env,valuer__m__ofr__m__k);
valuer__m__ofr__m__exp = (void *)test;
pc = &valuer__m__ofr__m__cps;
break; }
case _letcc_expr: {
void *body = _c->u._letcc._body;
valuer__m__ofr__m__exp = (void *)body;
valuer__m__ofr__m__env = (void *)envmtr_extendr__m__env(valuer__m__ofr__m__k,valuer__m__ofr__m__env);
pc = &valuer__m__ofr__m__cps;
break; }
case _throw_expr: {
void *kr__m__exp = _c->u._throw._kexp;
void *vr__m__exp = _c->u._throw._vexp;
valuer__m__ofr__m__k = (void *)ktr_throwr__m__outerr__m__k(kr__m__exp,valuer__m__ofr__m__env);
valuer__m__ofr__m__exp = (void *)vr__m__exp;
pc = &valuer__m__ofr__m__cps;
break; }
case _let_expr: {
void *e = _c->u._let._exp;
void *body = _c->u._let._body;
valuer__m__ofr__m__k = (void *)ktr_letr__m__k(body,valuer__m__ofr__m__env,valuer__m__ofr__m__k);
valuer__m__ofr__m__exp = (void *)e;
pc = &valuer__m__ofr__m__cps;
break; }
case _var_expr: {
void *y = _c->u._var._n;
applyr__m__envr__m__k = (void *)valuer__m__ofr__m__k;
applyr__m__envr__m__env = (void *)valuer__m__ofr__m__env;
applyr__m__envr__m__y = (void *)y;
pc = &applyr__m__env;
break; }
case _lambda_expr: {
void *body = _c->u._lambda._body;
applyr__m__kr__m__k = (void *)valuer__m__ofr__m__k;
applyr__m__kr__m__v = (void *)closr_maker__m__closure(body,valuer__m__ofr__m__env);
pc = &applyr__m__k;
break; }
case _app_expr: {
void *rator = _c->u._app._rator;
void *rand = _c->u._app._rand;
valuer__m__ofr__m__k = (void *)ktr_appr__m__outerr__m__k(rand,valuer__m__ofr__m__env,valuer__m__ofr__m__k);
valuer__m__ofr__m__exp = (void *)rator;
pc = &valuer__m__ofr__m__cps;
break; }
}
}

int mount_tram ()
{
srand (time (NULL));
jmp_buf jb;
_trstr trstr;
void *dismount;
int _status = setjmp(jb);
trstr.jmpbuf = &jb;
dismount = &trstr;
if(!_status) {
valuer__m__ofr__m__k= (void *)ktr_emptyr__m__k(dismount);
for(;;) {
pc();
}
}
return 0;
}
