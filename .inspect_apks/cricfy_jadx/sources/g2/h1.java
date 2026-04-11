package g2;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f4739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f4740e;
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f4741g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f4742h;
    public final Object i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f4743j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Object f4744k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Object f4745l;

    public h1() {
        this.f4737b = new ka.v[4];
        this.f4738c = new Matrix[4];
        this.f4739d = new Matrix[4];
        this.f4740e = new PointF();
        this.f = new Path();
        this.f4741g = new Path();
        this.f4742h = new ka.v();
        this.i = new float[2];
        this.f4743j = new float[2];
        this.f4744k = new Path();
        this.f4745l = new Path();
        this.f4736a = true;
        for (int i = 0; i < 4; i++) {
            ((ka.v[]) this.f4737b)[i] = new ka.v();
            ((Matrix[]) this.f4738c)[i] = new Matrix();
            ((Matrix[]) this.f4739d)[i] = new Matrix();
        }
    }

    public v1.f1 a(int i, ArrayList arrayList, s2.d1 d1Var) {
        ArrayList arrayList2 = (ArrayList) this.f4738c;
        if (!arrayList.isEmpty()) {
            this.f4744k = d1Var;
            for (int i10 = i; i10 < arrayList.size() + i; i10++) {
                g1 g1Var = (g1) arrayList.get(i10 - i);
                if (i10 > 0) {
                    g1 g1Var2 = (g1) arrayList2.get(i10 - 1);
                    g1Var.f4720d = g1Var2.f4717a.f11360o.f11299e.o() + g1Var2.f4720d;
                    g1Var.f4721e = false;
                    g1Var.f4719c.clear();
                } else {
                    g1Var.f4720d = 0;
                    g1Var.f4721e = false;
                    g1Var.f4719c.clear();
                }
                int iO = g1Var.f4717a.f11360o.f11299e.o();
                for (int i11 = i10; i11 < arrayList2.size(); i11++) {
                    ((g1) arrayList2.get(i11)).f4720d += iO;
                }
                arrayList2.add(i10, g1Var);
                ((HashMap) this.f4740e).put(g1Var.f4718b, g1Var);
                if (this.f4736a) {
                    g(g1Var);
                    if (((IdentityHashMap) this.f4739d).isEmpty()) {
                        ((HashSet) this.f4742h).add(g1Var);
                    } else {
                        f1 f1Var = (f1) ((HashMap) this.f).get(g1Var);
                        if (f1Var != null) {
                            f1Var.f4681a.d(f1Var.f4682b);
                        }
                    }
                }
            }
        }
        return c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(ka.m mVar, float[] fArr, float f, RectF rectF, p6.d dVar, Path path) {
        int i;
        char c9;
        float f10;
        p6.d dVar2;
        char c10;
        p6.d dVar3 = dVar;
        Matrix[] matrixArr = (Matrix[]) this.f4739d;
        float[] fArr2 = (float[]) this.i;
        ka.v[] vVarArr = (ka.v[]) this.f4737b;
        Matrix[] matrixArr2 = (Matrix[]) this.f4738c;
        path.rewind();
        Path path2 = (Path) this.f;
        path2.rewind();
        Path path3 = (Path) this.f4741g;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i10 = 0;
        while (true) {
            c9 = 0;
            if (i10 >= 4) {
                break;
            }
            PointF pointF = (PointF) this.f4740e;
            ka.d cVar = fArr == null ? i10 != 1 ? i10 != 2 ? i10 != 3 ? mVar.f : mVar.f7354e : mVar.f7356h : mVar.f7355g : new ka.c(fArr[i10]);
            com.bumptech.glide.d dVar4 = i10 != 1 ? i10 != 2 ? i10 != 3 ? mVar.f7351b : mVar.f7350a : mVar.f7353d : mVar.f7352c;
            ka.v vVar = vVarArr[i10];
            dVar4.getClass();
            Matrix[] matrixArr3 = matrixArr;
            dVar4.q(vVar, f, cVar.a(rectF));
            int i11 = i10 + 1;
            float f11 = (i11 % 4) * 90;
            matrixArr2[i10].reset();
            if (i10 == 1) {
                pointF.set(rectF.right, rectF.bottom);
            } else if (i10 == 2) {
                pointF.set(rectF.left, rectF.bottom);
            } else if (i10 != 3) {
                pointF.set(rectF.right, rectF.top);
            } else {
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i10].setTranslate(pointF.x, pointF.y);
            matrixArr2[i10].preRotate(f11);
            ka.v vVar2 = vVarArr[i10];
            fArr2[0] = vVar2.f7379b;
            fArr2[1] = vVar2.f7380c;
            matrixArr2[i10].mapPoints(fArr2);
            matrixArr3[i10].reset();
            matrixArr3[i10].setTranslate(fArr2[0], fArr2[1]);
            matrixArr3[i10].preRotate(f11);
            i10 = i11;
            matrixArr = matrixArr3;
        }
        Matrix[] matrixArr4 = matrixArr;
        int i12 = 0;
        for (i = 4; i12 < i; i = 4) {
            ka.v vVar3 = vVarArr[i12];
            vVar3.getClass();
            fArr2[c9] = 0.0f;
            fArr2[1] = vVar3.f7378a;
            matrixArr2[i12].mapPoints(fArr2);
            if (i12 == 0) {
                path.moveTo(fArr2[c9], fArr2[1]);
            } else {
                path.lineTo(fArr2[c9], fArr2[1]);
            }
            vVarArr[i12].b(matrixArr2[i12], path);
            if (dVar3 != null) {
                ka.v vVar4 = vVarArr[i12];
                Matrix matrix = matrixArr2[i12];
                ka.i iVar = (ka.i) dVar3.f10037w;
                BitSet bitSet = iVar.f7337z;
                vVar4.getClass();
                f10 = 0.0f;
                bitSet.set(i12, (boolean) c9);
                ka.u[] uVarArr = iVar.f7335x;
                vVar4.a(vVar4.f7382e);
                uVarArr[i12] = new ka.o(new ArrayList((ArrayList) vVar4.f7383g), new Matrix(matrix));
            } else {
                f10 = 0.0f;
            }
            Path path4 = (Path) this.f4744k;
            ka.v vVar5 = (ka.v) this.f4742h;
            int i13 = i12 + 1;
            int i14 = i13 % 4;
            ka.v vVar6 = vVarArr[i12];
            fArr2[0] = vVar6.f7379b;
            fArr2[1] = vVar6.f7380c;
            matrixArr2[i12].mapPoints(fArr2);
            float[] fArr3 = (float[]) this.f4743j;
            ka.v vVar7 = vVarArr[i14];
            vVar7.getClass();
            fArr3[0] = f10;
            fArr3[1] = vVar7.f7378a;
            matrixArr2[i14].mapPoints(fArr3);
            ka.v[] vVarArr2 = vVarArr;
            Matrix[] matrixArr5 = matrixArr2;
            float fMax = Math.max(((float) Math.hypot(fArr2[0] - fArr3[0], fArr2[1] - fArr3[1])) - 0.001f, f10);
            ka.v vVar8 = vVarArr2[i12];
            fArr2[0] = vVar8.f7379b;
            fArr2[1] = vVar8.f7380c;
            matrixArr5[i12].mapPoints(fArr2);
            if (i12 == 1 || i12 == 3) {
                Math.abs(rectF.centerX() - fArr2[0]);
            } else {
                Math.abs(rectF.centerY() - fArr2[1]);
            }
            vVar5.d(0.0f, 270.0f, 0.0f);
            (i12 != 1 ? i12 != 2 ? i12 != 3 ? mVar.f7357j : mVar.i : mVar.f7359l : mVar.f7358k).getClass();
            vVar5.c(fMax, 0.0f);
            path4.reset();
            vVar5.b(matrixArr4[i12], path4);
            if (this.f4736a && (f(path4, i12) || f(path4, i14))) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr2[0] = 0.0f;
                fArr2[1] = vVar5.f7378a;
                matrixArr4[i12].mapPoints(fArr2);
                path2.moveTo(fArr2[0], fArr2[1]);
                vVar5.b(matrixArr4[i12], path2);
            } else {
                vVar5.b(matrixArr4[i12], path);
            }
            if (dVar != null) {
                Matrix matrix2 = matrixArr4[i12];
                dVar2 = dVar;
                ka.i iVar2 = (ka.i) dVar2.f10037w;
                c10 = 0;
                iVar2.f7337z.set(i12 + 4, false);
                ka.u[] uVarArr2 = iVar2.f7336y;
                vVar5.a(vVar5.f7382e);
                uVarArr2[i12] = new ka.o(new ArrayList((ArrayList) vVar5.f7383g), new Matrix(matrix2));
            } else {
                dVar2 = dVar;
                c10 = 0;
            }
            c9 = c10;
            dVar3 = dVar2;
            i12 = i13;
            vVarArr = vVarArr2;
            matrixArr2 = matrixArr5;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public v1.f1 c() {
        ArrayList arrayList = (ArrayList) this.f4738c;
        if (arrayList.isEmpty()) {
            return v1.f1.f12674a;
        }
        int iO = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            g1 g1Var = (g1) arrayList.get(i);
            g1Var.f4720d = iO;
            iO += g1Var.f4717a.f11360o.f11299e.o();
        }
        return new n1(arrayList, (s2.d1) this.f4744k);
    }

    public void d() {
        Iterator it = ((HashSet) this.f4742h).iterator();
        while (it.hasNext()) {
            g1 g1Var = (g1) it.next();
            if (g1Var.f4719c.isEmpty()) {
                f1 f1Var = (f1) ((HashMap) this.f).get(g1Var);
                if (f1Var != null) {
                    f1Var.f4681a.d(f1Var.f4682b);
                }
                it.remove();
            }
        }
    }

    public void e(g1 g1Var) {
        if (g1Var.f4721e && g1Var.f4719c.isEmpty()) {
            f1 f1Var = (f1) ((HashMap) this.f).remove(g1Var);
            f1Var.getClass();
            e1 e1Var = f1Var.f4683c;
            s2.a aVar = f1Var.f4681a;
            aVar.p(f1Var.f4682b);
            aVar.s(e1Var);
            aVar.r(e1Var);
            ((HashSet) this.f4742h).remove(g1Var);
        }
    }

    public boolean f(Path path, int i) {
        Path path2 = (Path) this.f4745l;
        path2.reset();
        ((ka.v[]) this.f4737b)[i].b(((Matrix[]) this.f4738c)[i], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [g2.y0, s2.d0] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void g(g1 g1Var) {
        s2.x xVar = g1Var.f4717a;
        ?? r12 = new s2.d0() { // from class: g2.y0
            @Override // s2.d0
            public final void a(s2.a aVar, v1.f1 f1Var) {
                y1.x xVar2 = ((o0) this.f4949a.f4741g).C;
                xVar2.d(2);
                xVar2.e(22);
            }
        };
        e1 e1Var = new e1(this, g1Var);
        ((HashMap) this.f).put(g1Var, new f1(xVar, r12, e1Var));
        int i = y1.a0.f14551a;
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            looperMyLooper = Looper.getMainLooper();
        }
        Handler handler = new Handler(looperMyLooper, null);
        xVar.getClass();
        f3.a aVar = xVar.f11149c;
        aVar.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) aVar.f3937y;
        s2.h0 h0Var = new s2.h0();
        h0Var.f11220a = handler;
        h0Var.f11221b = e1Var;
        copyOnWriteArrayList.add(h0Var);
        Looper looperMyLooper2 = Looper.myLooper();
        if (looperMyLooper2 == null) {
            looperMyLooper2 = Looper.getMainLooper();
        }
        Handler handler2 = new Handler(looperMyLooper2, null);
        l2.k kVar = xVar.f11150d;
        kVar.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList2 = kVar.f7673c;
        l2.j jVar = new l2.j();
        jVar.f7669a = handler2;
        jVar.f7670b = e1Var;
        copyOnWriteArrayList2.add(jVar);
        xVar.l(r12, (b2.h0) this.f4745l, (h2.l) this.f4737b);
    }

    public void h(s2.a0 a0Var) {
        IdentityHashMap identityHashMap = (IdentityHashMap) this.f4739d;
        g1 g1Var = (g1) identityHashMap.remove(a0Var);
        g1Var.getClass();
        g1Var.f4717a.o(a0Var);
        g1Var.f4719c.remove(((s2.u) a0Var).f11327v);
        if (!identityHashMap.isEmpty()) {
            d();
        }
        e(g1Var);
    }

    public void i(int i, int i10) {
        ArrayList arrayList = (ArrayList) this.f4738c;
        for (int i11 = i10 - 1; i11 >= i; i11--) {
            g1 g1Var = (g1) arrayList.remove(i11);
            ((HashMap) this.f4740e).remove(g1Var.f4718b);
            int i12 = -g1Var.f4717a.f11360o.f11299e.o();
            for (int i13 = i11; i13 < arrayList.size(); i13++) {
                ((g1) arrayList.get(i13)).f4720d += i12;
            }
            g1Var.f4721e = true;
            if (this.f4736a) {
                e(g1Var);
            }
        }
    }

    public h1(o0 o0Var, h2.f fVar, y1.x xVar, h2.l lVar) {
        this.f4737b = lVar;
        this.f4741g = o0Var;
        this.f4744k = new s2.d1();
        this.f4739d = new IdentityHashMap();
        this.f4740e = new HashMap();
        this.f4738c = new ArrayList();
        this.i = fVar;
        this.f4743j = xVar;
        this.f = new HashMap();
        this.f4742h = new HashSet();
    }
}
