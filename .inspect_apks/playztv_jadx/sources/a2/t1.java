package a2;

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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f415e;
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f416g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f417h;
    public final Object i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f418j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Object f419k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Object f420l;

    public t1() {
        this.f412b = new q9.t[4];
        this.f413c = new Matrix[4];
        this.f414d = new Matrix[4];
        this.f415e = new PointF();
        this.f = new Path();
        this.f416g = new Path();
        this.f417h = new q9.t();
        this.i = new float[2];
        this.f418j = new float[2];
        this.f419k = new Path();
        this.f420l = new Path();
        this.f411a = true;
        for (int i = 0; i < 4; i++) {
            ((q9.t[]) this.f412b)[i] = new q9.t();
            ((Matrix[]) this.f413c)[i] = new Matrix();
            ((Matrix[]) this.f414d)[i] = new Matrix();
        }
    }

    public p1.f1 a(int i, ArrayList arrayList, o2.f1 f1Var) {
        ArrayList arrayList2 = (ArrayList) this.f413c;
        if (!arrayList.isEmpty()) {
            this.f419k = f1Var;
            for (int i10 = i; i10 < arrayList.size() + i; i10++) {
                s1 s1Var = (s1) arrayList.get(i10 - i);
                if (i10 > 0) {
                    s1 s1Var2 = (s1) arrayList2.get(i10 - 1);
                    s1Var.f404d = s1Var2.f401a.I.f9206e.o() + s1Var2.f404d;
                    s1Var.f405e = false;
                    s1Var.f403c.clear();
                } else {
                    s1Var.f404d = 0;
                    s1Var.f405e = false;
                    s1Var.f403c.clear();
                }
                int iO = s1Var.f401a.I.f9206e.o();
                for (int i11 = i10; i11 < arrayList2.size(); i11++) {
                    ((s1) arrayList2.get(i11)).f404d += iO;
                }
                arrayList2.add(i10, s1Var);
                ((HashMap) this.f415e).put(s1Var.f402b, s1Var);
                if (this.f411a) {
                    g(s1Var);
                    if (((IdentityHashMap) this.f414d).isEmpty()) {
                        ((HashSet) this.f417h).add(s1Var);
                    } else {
                        r1 r1Var = (r1) ((HashMap) this.f).get(s1Var);
                        if (r1Var != null) {
                            r1Var.f393a.e(r1Var.f394b);
                        }
                    }
                }
            }
        }
        return c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(q9.k kVar, float f, RectF rectF, o4.c cVar, Path path) {
        int i;
        char c9;
        float f4;
        o4.c cVar2;
        char c10;
        o4.c cVar3 = cVar;
        Matrix[] matrixArr = (Matrix[]) this.f414d;
        float[] fArr = (float[]) this.i;
        q9.t[] tVarArr = (q9.t[]) this.f412b;
        Matrix[] matrixArr2 = (Matrix[]) this.f413c;
        path.rewind();
        Path path2 = (Path) this.f;
        path2.rewind();
        Path path3 = (Path) this.f416g;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i10 = 0;
        while (true) {
            c9 = 0;
            if (i10 >= 4) {
                break;
            }
            PointF pointF = (PointF) this.f415e;
            q9.c cVar4 = i10 != 1 ? i10 != 2 ? i10 != 3 ? kVar.f : kVar.f11127e : kVar.f11129h : kVar.f11128g;
            ga.b bVar = i10 != 1 ? i10 != 2 ? i10 != 3 ? kVar.f11124b : kVar.f11123a : kVar.f11126d : kVar.f11125c;
            q9.t tVar = tVarArr[i10];
            bVar.getClass();
            Matrix[] matrixArr3 = matrixArr;
            bVar.o(tVar, f, cVar4.a(rectF));
            int i11 = i10 + 1;
            float f10 = (i11 % 4) * 90;
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
            matrixArr2[i10].preRotate(f10);
            q9.t tVar2 = tVarArr[i10];
            fArr[0] = tVar2.f11152b;
            fArr[1] = tVar2.f11153c;
            matrixArr2[i10].mapPoints(fArr);
            matrixArr3[i10].reset();
            matrixArr3[i10].setTranslate(fArr[0], fArr[1]);
            matrixArr3[i10].preRotate(f10);
            i10 = i11;
            matrixArr = matrixArr3;
        }
        Matrix[] matrixArr4 = matrixArr;
        int i12 = 0;
        for (i = 4; i12 < i; i = 4) {
            q9.t tVar3 = tVarArr[i12];
            tVar3.getClass();
            fArr[c9] = 0.0f;
            fArr[1] = tVar3.f11151a;
            matrixArr2[i12].mapPoints(fArr);
            if (i12 == 0) {
                path.moveTo(fArr[c9], fArr[1]);
            } else {
                path.lineTo(fArr[c9], fArr[1]);
            }
            tVarArr[i12].b(matrixArr2[i12], path);
            if (cVar3 != null) {
                q9.t tVar4 = tVarArr[i12];
                Matrix matrix = matrixArr2[i12];
                q9.g gVar = (q9.g) cVar3.f9349u;
                BitSet bitSet = gVar.f11108x;
                tVar4.getClass();
                f4 = 0.0f;
                bitSet.set(i12, (boolean) c9);
                q9.s[] sVarArr = gVar.f11106v;
                tVar4.a(tVar4.f11155e);
                sVarArr[i12] = new q9.m(new ArrayList((ArrayList) tVar4.f11156g), new Matrix(matrix));
            } else {
                f4 = 0.0f;
            }
            Path path4 = (Path) this.f419k;
            q9.t tVar5 = (q9.t) this.f417h;
            int i13 = i12 + 1;
            int i14 = i13 % 4;
            q9.t tVar6 = tVarArr[i12];
            fArr[0] = tVar6.f11152b;
            fArr[1] = tVar6.f11153c;
            matrixArr2[i12].mapPoints(fArr);
            float[] fArr2 = (float[]) this.f418j;
            q9.t tVar7 = tVarArr[i14];
            tVar7.getClass();
            fArr2[0] = f4;
            fArr2[1] = tVar7.f11151a;
            matrixArr2[i14].mapPoints(fArr2);
            q9.t[] tVarArr2 = tVarArr;
            Matrix[] matrixArr5 = matrixArr2;
            float fMax = Math.max(((float) Math.hypot(fArr[0] - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, f4);
            q9.t tVar8 = tVarArr2[i12];
            fArr[0] = tVar8.f11152b;
            fArr[1] = tVar8.f11153c;
            matrixArr5[i12].mapPoints(fArr);
            if (i12 == 1 || i12 == 3) {
                Math.abs(rectF.centerX() - fArr[0]);
            } else {
                Math.abs(rectF.centerY() - fArr[1]);
            }
            tVar5.d(0.0f, 270.0f, 0.0f);
            (i12 != 1 ? i12 != 2 ? i12 != 3 ? kVar.f11130j : kVar.i : kVar.f11132l : kVar.f11131k).getClass();
            tVar5.c(fMax, 0.0f);
            path4.reset();
            tVar5.b(matrixArr4[i12], path4);
            if (this.f411a && (f(path4, i12) || f(path4, i14))) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr[0] = 0.0f;
                fArr[1] = tVar5.f11151a;
                matrixArr4[i12].mapPoints(fArr);
                path2.moveTo(fArr[0], fArr[1]);
                tVar5.b(matrixArr4[i12], path2);
            } else {
                tVar5.b(matrixArr4[i12], path);
            }
            if (cVar != null) {
                Matrix matrix2 = matrixArr4[i12];
                cVar2 = cVar;
                q9.g gVar2 = (q9.g) cVar2.f9349u;
                c10 = 0;
                gVar2.f11108x.set(i12 + 4, false);
                q9.s[] sVarArr2 = gVar2.f11107w;
                tVar5.a(tVar5.f11155e);
                sVarArr2[i12] = new q9.m(new ArrayList((ArrayList) tVar5.f11156g), new Matrix(matrix2));
            } else {
                cVar2 = cVar;
                c10 = 0;
            }
            c9 = c10;
            cVar3 = cVar2;
            i12 = i13;
            tVarArr = tVarArr2;
            matrixArr2 = matrixArr5;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public p1.f1 c() {
        ArrayList arrayList = (ArrayList) this.f413c;
        if (arrayList.isEmpty()) {
            return p1.f1.f9741a;
        }
        int iO = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            s1 s1Var = (s1) arrayList.get(i);
            s1Var.f404d = iO;
            iO += s1Var.f401a.I.f9206e.o();
        }
        return new z1(arrayList, (o2.f1) this.f419k);
    }

    public void d() {
        Iterator it = ((HashSet) this.f417h).iterator();
        while (it.hasNext()) {
            s1 s1Var = (s1) it.next();
            if (s1Var.f403c.isEmpty()) {
                r1 r1Var = (r1) ((HashMap) this.f).get(s1Var);
                if (r1Var != null) {
                    r1Var.f393a.e(r1Var.f394b);
                }
                it.remove();
            }
        }
    }

    public void e(s1 s1Var) {
        if (s1Var.f405e && s1Var.f403c.isEmpty()) {
            r1 r1Var = (r1) ((HashMap) this.f).remove(s1Var);
            r1Var.getClass();
            q1 q1Var = r1Var.f395c;
            o2.a aVar = r1Var.f393a;
            aVar.s(r1Var.f394b);
            aVar.w(q1Var);
            aVar.v(q1Var);
            ((HashSet) this.f417h).remove(s1Var);
        }
    }

    public boolean f(Path path, int i) {
        Path path2 = (Path) this.f420l;
        path2.reset();
        ((q9.t[]) this.f412b)[i].b(((Matrix[]) this.f413c)[i], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [a2.j1, o2.e0] */
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
    public void g(s1 s1Var) {
        o2.y yVar = s1Var.f401a;
        ?? r12 = new o2.e0() { // from class: a2.j1
            @Override // o2.e0
            public final void a(o2.a aVar, p1.f1 f1Var) {
                s1.y yVar2 = ((x0) this.f296a.f416g).B;
                yVar2.d(2);
                yVar2.e(22);
            }
        };
        q1 q1Var = new q1(this, s1Var);
        ((HashMap) this.f).put(s1Var, new r1(yVar, r12, q1Var));
        int i = s1.b0.f11647a;
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            looperMyLooper = Looper.getMainLooper();
        }
        Handler handler = new Handler(looperMyLooper, null);
        yVar.getClass();
        aa.l0 l0Var = yVar.f9053w;
        l0Var.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) l0Var.f707x;
        o2.j0 j0Var = new o2.j0();
        j0Var.f9146a = handler;
        j0Var.f9147b = q1Var;
        copyOnWriteArrayList.add(j0Var);
        Looper looperMyLooper2 = Looper.myLooper();
        if (looperMyLooper2 == null) {
            looperMyLooper2 = Looper.getMainLooper();
        }
        Handler handler2 = new Handler(looperMyLooper2, null);
        f2.k kVar = yVar.f9054x;
        kVar.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList2 = kVar.f4741c;
        f2.j jVar = new f2.j();
        jVar.f4737a = handler2;
        jVar.f4738b = q1Var;
        copyOnWriteArrayList2.add(jVar);
        yVar.o(r12, (v1.e0) this.f420l, (b2.o) this.f412b);
    }

    public void h(o2.b0 b0Var) {
        IdentityHashMap identityHashMap = (IdentityHashMap) this.f414d;
        s1 s1Var = (s1) identityHashMap.remove(b0Var);
        s1Var.getClass();
        s1Var.f401a.r(b0Var);
        s1Var.f403c.remove(((o2.v) b0Var).f9235u);
        if (!identityHashMap.isEmpty()) {
            d();
        }
        e(s1Var);
    }

    public void i(int i, int i10) {
        ArrayList arrayList = (ArrayList) this.f413c;
        for (int i11 = i10 - 1; i11 >= i; i11--) {
            s1 s1Var = (s1) arrayList.remove(i11);
            ((HashMap) this.f415e).remove(s1Var.f402b);
            int i12 = -s1Var.f401a.I.f9206e.o();
            for (int i13 = i11; i13 < arrayList.size(); i13++) {
                ((s1) arrayList.get(i13)).f404d += i12;
            }
            s1Var.f405e = true;
            if (this.f411a) {
                e(s1Var);
            }
        }
    }

    public t1(x0 x0Var, b2.h hVar, s1.y yVar, b2.o oVar) {
        this.f412b = oVar;
        this.f416g = x0Var;
        this.f419k = new o2.f1();
        this.f414d = new IdentityHashMap();
        this.f415e = new HashMap();
        this.f413c = new ArrayList();
        this.i = hVar;
        this.f418j = yVar;
        this.f = new HashMap();
        this.f417h = new HashSet();
    }
}
