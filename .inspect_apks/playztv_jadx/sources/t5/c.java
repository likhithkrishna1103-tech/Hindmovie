package t5;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
import l5.w;
import l5.z;
import o5.r;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends b {
    public o5.e C;
    public final ArrayList D;
    public final RectF E;
    public final RectF F;
    public final Paint G;
    public float H;
    public boolean I;

    public c(w wVar, e eVar, List list, l5.j jVar) {
        b bVar;
        b cVar;
        String str;
        super(wVar, eVar);
        this.D = new ArrayList();
        this.E = new RectF();
        this.F = new RectF();
        this.G = new Paint();
        this.I = true;
        r5.b bVar2 = eVar.f12193s;
        if (bVar2 != null) {
            o5.e eVarD0 = bVar2.D0();
            this.C = eVarD0;
            d(eVarD0);
            this.C.a(this);
        } else {
            this.C = null;
        }
        s.g gVar = new s.g(jVar.f7864j.size());
        int size = list.size() - 1;
        b bVar3 = null;
        while (true) {
            if (size < 0) {
                for (int i = 0; i < gVar.i(); i++) {
                    b bVar4 = (b) gVar.d(gVar.g(i));
                    if (bVar4 != null && (bVar = (b) gVar.d(bVar4.f12166p.f)) != null) {
                        bVar4.f12170t = bVar;
                    }
                }
                return;
            }
            e eVar2 = (e) list.get(size);
            int iC = v.e.c(eVar2.f12181e);
            if (iC == 0) {
                cVar = new c(wVar, eVar2, (List) jVar.f7859c.get(eVar2.f12182g), jVar);
            } else if (iC == 1) {
                cVar = new h(wVar, eVar2);
            } else if (iC == 2) {
                cVar = new d(wVar, eVar2);
            } else if (iC == 3) {
                cVar = new f(wVar, eVar2);
            } else if (iC == 4) {
                cVar = new g(wVar, eVar2, this, jVar);
            } else if (iC != 5) {
                switch (eVar2.f12181e) {
                    case 1:
                        str = "PRE_COMP";
                        break;
                    case 2:
                        str = "SOLID";
                        break;
                    case 3:
                        str = "IMAGE";
                        break;
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        str = "NULL";
                        break;
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        str = "SHAPE";
                        break;
                    case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                        str = "TEXT";
                        break;
                    case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                        str = "UNKNOWN";
                        break;
                    default:
                        str = "null";
                        break;
                }
                x5.b.b("Unknown layer type ".concat(str));
                cVar = null;
            } else {
                cVar = new j(wVar, eVar2);
            }
            if (cVar != null) {
                gVar.h(cVar.f12166p.f12180d, cVar);
                if (bVar3 != null) {
                    bVar3.f12169s = cVar;
                    bVar3 = null;
                } else {
                    this.D.add(0, cVar);
                    int iC2 = v.e.c(eVar2.f12195u);
                    if (iC2 == 1 || iC2 == 2) {
                        bVar3 = cVar;
                    }
                }
            }
            size--;
        }
    }

    @Override // t5.b, n5.e
    public final void a(RectF rectF, Matrix matrix, boolean z2) {
        super.a(rectF, matrix, z2);
        ArrayList arrayList = this.D;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            RectF rectF2 = this.E;
            rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
            ((b) arrayList.get(size)).a(rectF2, this.f12164n, true);
            rectF.union(rectF2);
        }
    }

    @Override // t5.b, q5.f
    public final void h(Object obj, p2.c cVar) {
        super.h(obj, cVar);
        if (obj == z.f7952z) {
            r rVar = new r(null, cVar);
            this.C = rVar;
            rVar.a(this);
            d(this.C);
        }
    }

    @Override // t5.b
    public final void k(Canvas canvas, Matrix matrix, int i) {
        e eVar = this.f12166p;
        float f = eVar.f12189o;
        float f4 = eVar.f12190p;
        RectF rectF = this.F;
        rectF.set(0.0f, 0.0f, f, f4);
        matrix.mapRect(rectF);
        boolean z2 = this.f12165o.M;
        ArrayList arrayList = this.D;
        boolean z10 = z2 && arrayList.size() > 1 && i != 255;
        if (z10) {
            Paint paint = this.G;
            paint.setAlpha(i);
            b8.j jVar = x5.g.f14267a;
            canvas.saveLayer(rectF, paint);
        } else {
            canvas.save();
        }
        if (z10) {
            i = 255;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((this.I || !"__container".equals(eVar.f12179c)) && !rectF.isEmpty()) ? canvas.clipRect(rectF) : true) {
                ((b) arrayList.get(size)).e(canvas, matrix, i);
            }
        }
        canvas.restore();
    }

    @Override // t5.b
    public final void q(q5.e eVar, int i, ArrayList arrayList, q5.e eVar2) {
        int i10 = 0;
        while (true) {
            ArrayList arrayList2 = this.D;
            if (i10 >= arrayList2.size()) {
                return;
            }
            ((b) arrayList2.get(i10)).g(eVar, i, arrayList, eVar2);
            i10++;
        }
    }

    @Override // t5.b
    public final void r(boolean z2) {
        super.r(z2);
        ArrayList arrayList = this.D;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((b) obj).r(z2);
        }
    }

    @Override // t5.b
    public final void s(float f) {
        this.H = f;
        super.s(f);
        o5.e eVar = this.C;
        e eVar2 = this.f12166p;
        if (eVar != null) {
            l5.j jVar = this.f12165o.f7918u;
            f = ((((Float) eVar.e()).floatValue() * eVar2.f12178b.f7868n) - eVar2.f12178b.f7866l) / ((jVar.f7867m - jVar.f7866l) + 0.01f);
        }
        if (this.C == null) {
            float f4 = eVar2.f12188n;
            l5.j jVar2 = eVar2.f12178b;
            f -= f4 / (jVar2.f7867m - jVar2.f7866l);
        }
        if (eVar2.f12187m != 0.0f && !"__container".equals(eVar2.f12179c)) {
            f /= eVar2.f12187m;
        }
        ArrayList arrayList = this.D;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((b) arrayList.get(size)).s(f);
        }
    }
}
