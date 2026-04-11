package o6;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import androidx.emoji2.text.v;
import g6.e0;
import g6.w;
import j6.q;
import j6.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements i6.f, j6.a, l6.f {
    public float A;
    public BlurMaskFilter B;
    public h6.a C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f9508a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f9509b = new Matrix();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f9510c = new Matrix();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h6.a f9511d = new h6.a(1, 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h6.a f9512e;
    public final h6.a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h6.a f9513g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h6.a f9514h;
    public final RectF i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f9515j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f9516k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f9517l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RectF f9518m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Matrix f9519n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final w f9520o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d f9521p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final v f9522q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final j6.i f9523r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a f9524s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public a f9525t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List f9526u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f9527v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final r f9528w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f9529x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f9530y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public h6.a f9531z;

    public a(w wVar, d dVar) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.f9512e = new h6.a(mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.f = new h6.a(mode2);
        h6.a aVar = new h6.a(1, 0);
        this.f9513g = aVar;
        PorterDuff.Mode mode3 = PorterDuff.Mode.CLEAR;
        h6.a aVar2 = new h6.a();
        aVar2.setXfermode(new PorterDuffXfermode(mode3));
        this.f9514h = aVar2;
        this.i = new RectF();
        this.f9515j = new RectF();
        this.f9516k = new RectF();
        this.f9517l = new RectF();
        this.f9518m = new RectF();
        this.f9519n = new Matrix();
        this.f9527v = new ArrayList();
        this.f9529x = true;
        this.A = 0.0f;
        this.f9520o = wVar;
        this.f9521p = dVar;
        List list = dVar.f9538h;
        if (dVar.f9550u == 3) {
            aVar.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            aVar.setXfermode(new PorterDuffXfermode(mode));
        }
        m6.e eVar = dVar.i;
        eVar.getClass();
        r rVar = new r(eVar);
        this.f9528w = rVar;
        rVar.b(this);
        if (list != null && !list.isEmpty()) {
            v vVar = new v(list);
            this.f9522q = vVar;
            ArrayList arrayList = (ArrayList) vVar.f888w;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((j6.e) obj).a(this);
            }
            ArrayList arrayList2 = (ArrayList) this.f9522q.f889x;
            int size2 = arrayList2.size();
            int i10 = 0;
            while (i10 < size2) {
                Object obj2 = arrayList2.get(i10);
                i10++;
                j6.e eVar2 = (j6.e) obj2;
                d(eVar2);
                eVar2.a(this);
            }
        }
        d dVar2 = this.f9521p;
        if (dVar2.f9549t.isEmpty()) {
            if (true != this.f9529x) {
                this.f9529x = true;
                this.f9520o.invalidateSelf();
                return;
            }
            return;
        }
        j6.i iVar = new j6.i(dVar2.f9549t);
        this.f9523r = iVar;
        iVar.f6631b = true;
        iVar.a(new q(3, this));
        boolean z10 = ((Float) this.f9523r.e()).floatValue() == 1.0f;
        if (z10 != this.f9529x) {
            this.f9529x = z10;
            this.f9520o.invalidateSelf();
        }
        d(this.f9523r);
    }

    @Override // i6.f
    public void a(RectF rectF, Matrix matrix, boolean z10) {
        this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        i();
        Matrix matrix2 = this.f9519n;
        matrix2.set(matrix);
        if (z10) {
            List list = this.f9526u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    matrix2.preConcat(((a) this.f9526u.get(size)).f9528w.e());
                }
            } else {
                a aVar = this.f9525t;
                if (aVar != null) {
                    matrix2.preConcat(aVar.f9528w.e());
                }
            }
        }
        matrix2.preConcat(this.f9528w.e());
    }

    @Override // j6.a
    public final void b() {
        this.f9520o.invalidateSelf();
    }

    public final void d(j6.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f9527v.add(eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0116  */
    @Override // i6.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(android.graphics.Canvas r22, android.graphics.Matrix r23, int r24, s6.a r25) {
        /*
            Method dump skipped, instruction units count: 1016
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o6.a.e(android.graphics.Canvas, android.graphics.Matrix, int, s6.a):void");
    }

    @Override // l6.f
    public final void g(l6.e eVar, int i, ArrayList arrayList, l6.e eVar2) {
        a aVar = this.f9524s;
        d dVar = this.f9521p;
        if (aVar != null) {
            String str = aVar.f9521p.f9534c;
            l6.e eVar3 = new l6.e(eVar2);
            eVar3.f7858a.add(str);
            if (eVar.a(i, this.f9524s.f9521p.f9534c)) {
                a aVar2 = this.f9524s;
                l6.e eVar4 = new l6.e(eVar3);
                eVar4.f7859b = aVar2;
                arrayList.add(eVar4);
            }
            if (eVar.c(i, this.f9524s.f9521p.f9534c) && eVar.d(i, dVar.f9534c)) {
                this.f9524s.p(eVar, eVar.b(i, this.f9524s.f9521p.f9534c) + i, arrayList, eVar3);
            }
        }
        String str2 = dVar.f9534c;
        String str3 = dVar.f9534c;
        if (eVar.c(i, str2)) {
            if (!"__container".equals(str3)) {
                l6.e eVar5 = new l6.e(eVar2);
                eVar5.f7858a.add(str3);
                if (eVar.a(i, str3)) {
                    l6.e eVar6 = new l6.e(eVar5);
                    eVar6.f7859b = this;
                    arrayList.add(eVar6);
                }
                eVar2 = eVar5;
            }
            if (eVar.d(i, str3)) {
                p(eVar, eVar.b(i, str3) + i, arrayList, eVar2);
            }
        }
    }

    @Override // l6.f
    public void h(Object obj, nb.w wVar) {
        this.f9528w.c(obj, wVar);
    }

    public final void i() {
        if (this.f9526u != null) {
            return;
        }
        if (this.f9525t == null) {
            this.f9526u = Collections.EMPTY_LIST;
            return;
        }
        this.f9526u = new ArrayList();
        for (a aVar = this.f9525t; aVar != null; aVar = aVar.f9525t) {
            this.f9526u.add(aVar);
        }
    }

    public final void j(Canvas canvas) {
        RectF rectF = this.i;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f9514h);
    }

    public abstract void k(Canvas canvas, Matrix matrix, int i, s6.a aVar);

    public l4.a l() {
        return this.f9521p.f9552w;
    }

    public final boolean m() {
        v vVar = this.f9522q;
        return (vVar == null || ((ArrayList) vVar.f888w).isEmpty()) ? false : true;
    }

    public final void n() {
        e0 e0Var = this.f9520o.f5152v.f5086a;
        String str = this.f9521p.f9534c;
        HashMap map = e0Var.f5069c;
        if (e0Var.f5067a) {
            s6.f fVar = (s6.f) map.get(str);
            if (fVar == null) {
                fVar = new s6.f();
                map.put(str, fVar);
            }
            int i = fVar.f11557a + 1;
            fVar.f11557a = i;
            if (i == Integer.MAX_VALUE) {
                fVar.f11557a = i / 2;
            }
            if (str.equals("__container")) {
                v.f fVar2 = e0Var.f5068b;
                fVar2.getClass();
                v.a aVar = new v.a(fVar2);
                if (aVar.hasNext()) {
                    aVar.next().getClass();
                    throw new ClassCastException();
                }
            }
        }
    }

    public final void o(j6.e eVar) {
        this.f9527v.remove(eVar);
    }

    public void q(boolean z10) {
        if (z10 && this.f9531z == null) {
            this.f9531z = new h6.a();
        }
        this.f9530y = z10;
    }

    public void r(float f) {
        r rVar = this.f9528w;
        j6.e eVar = rVar.f6678p;
        if (eVar != null) {
            eVar.i(f);
        }
        j6.e eVar2 = rVar.f6684v;
        if (eVar2 != null) {
            eVar2.i(f);
        }
        j6.e eVar3 = rVar.f6685w;
        if (eVar3 != null) {
            eVar3.i(f);
        }
        j6.e eVar4 = rVar.f6674l;
        if (eVar4 != null) {
            eVar4.i(f);
        }
        j6.e eVar5 = rVar.f6675m;
        if (eVar5 != null) {
            eVar5.i(f);
        }
        j6.e eVar6 = rVar.f6676n;
        if (eVar6 != null) {
            eVar6.i(f);
        }
        j6.e eVar7 = rVar.f6677o;
        if (eVar7 != null) {
            eVar7.i(f);
        }
        j6.i iVar = rVar.f6679q;
        if (iVar != null) {
            iVar.i(f);
        }
        j6.i iVar2 = rVar.f6680r;
        if (iVar2 != null) {
            iVar2.i(f);
        }
        j6.i iVar3 = rVar.f6681s;
        if (iVar3 != null) {
            iVar3.i(f);
        }
        j6.i iVar4 = rVar.f6682t;
        if (iVar4 != null) {
            iVar4.i(f);
        }
        j6.i iVar5 = rVar.f6683u;
        if (iVar5 != null) {
            iVar5.i(f);
        }
        int i = 0;
        v vVar = this.f9522q;
        if (vVar != null) {
            ArrayList arrayList = (ArrayList) vVar.f888w;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                ((j6.e) arrayList.get(i10)).i(f);
            }
        }
        j6.i iVar6 = this.f9523r;
        if (iVar6 != null) {
            iVar6.i(f);
        }
        a aVar = this.f9524s;
        if (aVar != null) {
            aVar.r(f);
        }
        while (true) {
            ArrayList arrayList2 = this.f9527v;
            if (i >= arrayList2.size()) {
                return;
            }
            ((j6.e) arrayList2.get(i)).i(f);
            i++;
        }
    }

    @Override // i6.d
    public final void c(List list, List list2) {
    }

    public void p(l6.e eVar, int i, ArrayList arrayList, l6.e eVar2) {
    }
}
