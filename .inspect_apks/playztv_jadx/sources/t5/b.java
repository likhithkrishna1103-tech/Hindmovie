package t5;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import l5.d0;
import l5.w;
import o5.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements n5.e, o5.a, q5.f {
    public float A;
    public BlurMaskFilter B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f12153a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f12154b = new Matrix();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f12155c = new Matrix();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m5.a f12156d = new m5.a(1, 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m5.a f12157e;
    public final m5.a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m5.a f12158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m5.a f12159h;
    public final RectF i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f12160j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f12161k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RectF f12162l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RectF f12163m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Matrix f12164n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final w f12165o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final e f12166p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final kc.b f12167q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final o5.i f12168r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public b f12169s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public b f12170t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List f12171u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f12172v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final q f12173w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12174x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f12175y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public m5.a f12176z;

    public b(w wVar, e eVar) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.f12157e = new m5.a(mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.f = new m5.a(mode2);
        m5.a aVar = new m5.a(1, 0);
        this.f12158g = aVar;
        PorterDuff.Mode mode3 = PorterDuff.Mode.CLEAR;
        m5.a aVar2 = new m5.a();
        aVar2.setXfermode(new PorterDuffXfermode(mode3));
        this.f12159h = aVar2;
        this.i = new RectF();
        this.f12160j = new RectF();
        this.f12161k = new RectF();
        this.f12162l = new RectF();
        this.f12163m = new RectF();
        this.f12164n = new Matrix();
        this.f12172v = new ArrayList();
        this.f12174x = true;
        this.A = 0.0f;
        this.f12165o = wVar;
        this.f12166p = eVar;
        List list = eVar.f12183h;
        if (eVar.f12195u == 3) {
            aVar.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            aVar.setXfermode(new PorterDuffXfermode(mode));
        }
        r5.d dVar = eVar.i;
        dVar.getClass();
        q qVar = new q(dVar);
        this.f12173w = qVar;
        qVar.b(this);
        if (list != null && !list.isEmpty()) {
            kc.b bVar = new kc.b(list);
            this.f12167q = bVar;
            ArrayList arrayList = (ArrayList) bVar.f7620v;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((o5.e) obj).a(this);
            }
            ArrayList arrayList2 = (ArrayList) this.f12167q.f7621w;
            int size2 = arrayList2.size();
            int i10 = 0;
            while (i10 < size2) {
                Object obj2 = arrayList2.get(i10);
                i10++;
                o5.e eVar2 = (o5.e) obj2;
                d(eVar2);
                eVar2.a(this);
            }
        }
        e eVar3 = this.f12166p;
        if (eVar3.f12194t.isEmpty()) {
            if (true != this.f12174x) {
                this.f12174x = true;
                this.f12165o.invalidateSelf();
                return;
            }
            return;
        }
        o5.i iVar = new o5.i(eVar3.f12194t);
        this.f12168r = iVar;
        iVar.f9376b = true;
        iVar.a(new o5.a() { // from class: t5.a
            @Override // o5.a
            public final void b() {
                b bVar2 = this.f12152a;
                boolean z2 = bVar2.f12168r.k() == 1.0f;
                if (z2 != bVar2.f12174x) {
                    bVar2.f12174x = z2;
                    bVar2.f12165o.invalidateSelf();
                }
            }
        });
        boolean z2 = ((Float) this.f12168r.e()).floatValue() == 1.0f;
        if (z2 != this.f12174x) {
            this.f12174x = z2;
            this.f12165o.invalidateSelf();
        }
        d(this.f12168r);
    }

    @Override // n5.e
    public void a(RectF rectF, Matrix matrix, boolean z2) {
        this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        i();
        Matrix matrix2 = this.f12164n;
        matrix2.set(matrix);
        if (z2) {
            List list = this.f12171u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    matrix2.preConcat(((b) this.f12171u.get(size)).f12173w.e());
                }
            } else {
                b bVar = this.f12170t;
                if (bVar != null) {
                    matrix2.preConcat(bVar.f12173w.e());
                }
            }
        }
        matrix2.preConcat(this.f12173w.e());
    }

    @Override // o5.a
    public final void b() {
        this.f12165o.invalidateSelf();
    }

    public final void d(o5.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f12172v.add(eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0105  */
    @Override // n5.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(android.graphics.Canvas r21, android.graphics.Matrix r22, int r23) {
        /*
            Method dump skipped, instruction units count: 858
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t5.b.e(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    @Override // q5.f
    public final void g(q5.e eVar, int i, ArrayList arrayList, q5.e eVar2) {
        b bVar = this.f12169s;
        e eVar3 = this.f12166p;
        if (bVar != null) {
            String str = bVar.f12166p.f12179c;
            q5.e eVar4 = new q5.e(eVar2);
            eVar4.f11011a.add(str);
            if (eVar.a(this.f12169s.f12166p.f12179c, i)) {
                b bVar2 = this.f12169s;
                q5.e eVar5 = new q5.e(eVar4);
                eVar5.f11012b = bVar2;
                arrayList.add(eVar5);
            }
            if (eVar.d(eVar3.f12179c, i)) {
                this.f12169s.q(eVar, eVar.b(this.f12169s.f12166p.f12179c, i) + i, arrayList, eVar4);
            }
        }
        String str2 = eVar3.f12179c;
        String str3 = eVar3.f12179c;
        if (eVar.c(str2, i)) {
            if (!"__container".equals(str3)) {
                q5.e eVar6 = new q5.e(eVar2);
                eVar6.f11011a.add(str3);
                if (eVar.a(str3, i)) {
                    q5.e eVar7 = new q5.e(eVar6);
                    eVar7.f11012b = this;
                    arrayList.add(eVar7);
                }
                eVar2 = eVar6;
            }
            if (eVar.d(str3, i)) {
                q(eVar, eVar.b(str3, i) + i, arrayList, eVar2);
            }
        }
    }

    @Override // q5.f
    public void h(Object obj, p2.c cVar) {
        this.f12173w.c(obj, cVar);
    }

    public final void i() {
        if (this.f12171u != null) {
            return;
        }
        if (this.f12170t == null) {
            this.f12171u = Collections.EMPTY_LIST;
            return;
        }
        this.f12171u = new ArrayList();
        for (b bVar = this.f12170t; bVar != null; bVar = bVar.f12170t) {
            this.f12171u.add(bVar);
        }
    }

    public final void j(Canvas canvas) {
        RectF rectF = this.i;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f12159h);
    }

    public abstract void k(Canvas canvas, Matrix matrix, int i);

    public q0.e l() {
        return this.f12166p.f12197w;
    }

    public zc.c m() {
        return this.f12166p.f12198x;
    }

    public final boolean n() {
        kc.b bVar = this.f12167q;
        return (bVar == null || ((ArrayList) bVar.f7620v).isEmpty()) ? false : true;
    }

    public final void o() {
        d0 d0Var = this.f12165o.f7918u.f7857a;
        String str = this.f12166p.f12179c;
        HashMap map = d0Var.f7836c;
        if (d0Var.f7834a) {
            x5.e eVar = (x5.e) map.get(str);
            if (eVar == null) {
                eVar = new x5.e();
                map.put(str, eVar);
            }
            int i = eVar.f14265a + 1;
            eVar.f14265a = i;
            if (i == Integer.MAX_VALUE) {
                eVar.f14265a = i / 2;
            }
            if (str.equals("__container")) {
                s.f fVar = d0Var.f7835b;
                fVar.getClass();
                s.a aVar = new s.a(fVar);
                if (aVar.hasNext()) {
                    aVar.next().getClass();
                    throw new ClassCastException();
                }
            }
        }
    }

    public final void p(o5.e eVar) {
        this.f12172v.remove(eVar);
    }

    public void r(boolean z2) {
        if (z2 && this.f12176z == null) {
            this.f12176z = new m5.a();
        }
        this.f12175y = z2;
    }

    public void s(float f) {
        q qVar = this.f12173w;
        o5.e eVar = qVar.f9415j;
        if (eVar != null) {
            eVar.i(f);
        }
        o5.e eVar2 = qVar.f9418m;
        if (eVar2 != null) {
            eVar2.i(f);
        }
        o5.e eVar3 = qVar.f9419n;
        if (eVar3 != null) {
            eVar3.i(f);
        }
        o5.e eVar4 = qVar.f;
        if (eVar4 != null) {
            eVar4.i(f);
        }
        o5.e eVar5 = qVar.f9413g;
        if (eVar5 != null) {
            eVar5.i(f);
        }
        o5.e eVar6 = qVar.f9414h;
        if (eVar6 != null) {
            eVar6.i(f);
        }
        o5.e eVar7 = qVar.i;
        if (eVar7 != null) {
            eVar7.i(f);
        }
        o5.i iVar = qVar.f9416k;
        if (iVar != null) {
            iVar.i(f);
        }
        o5.i iVar2 = qVar.f9417l;
        if (iVar2 != null) {
            iVar2.i(f);
        }
        kc.b bVar = this.f12167q;
        if (bVar != null) {
            ArrayList arrayList = (ArrayList) bVar.f7620v;
            for (int i = 0; i < arrayList.size(); i++) {
                ((o5.e) arrayList.get(i)).i(f);
            }
        }
        o5.i iVar3 = this.f12168r;
        if (iVar3 != null) {
            iVar3.i(f);
        }
        b bVar2 = this.f12169s;
        if (bVar2 != null) {
            bVar2.s(f);
        }
        ArrayList arrayList2 = this.f12172v;
        arrayList2.size();
        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
            ((o5.e) arrayList2.get(i10)).i(f);
        }
        arrayList2.size();
    }

    @Override // n5.c
    public final void c(List list, List list2) {
    }

    public void q(q5.e eVar, int i, ArrayList arrayList, q5.e eVar2) {
    }
}
