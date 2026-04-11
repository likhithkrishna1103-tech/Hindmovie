package n5;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.List;
import l5.w;
import l5.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements e, o5.a, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f8721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m5.a f8722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t5.b f8723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f8725e;
    public final ArrayList f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o5.f f8726g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o5.f f8727h;
    public o5.r i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final w f8728j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public o5.e f8729k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f8730l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final o5.h f8731m;

    public g(w wVar, t5.b bVar, s5.l lVar) {
        PorterDuff.Mode mode;
        Path path = new Path();
        this.f8721a = path;
        int i = 0;
        m5.a aVar = new m5.a(1, 0);
        this.f8722b = aVar;
        this.f = new ArrayList();
        this.f8723c = bVar;
        String str = lVar.f11841c;
        r5.a aVar2 = lVar.f11843e;
        r5.a aVar3 = lVar.f11842d;
        this.f8724d = str;
        this.f8725e = lVar.f;
        this.f8728j = wVar;
        if (bVar.l() != null) {
            o5.e eVarD0 = ((r5.b) bVar.l().f10436v).D0();
            this.f8729k = eVarD0;
            eVarD0.a(this);
            bVar.d(this.f8729k);
        }
        if (bVar.m() != null) {
            this.f8731m = new o5.h(this, bVar, bVar.m());
        }
        if (aVar3 == null) {
            this.f8726g = null;
            this.f8727h = null;
            return;
        }
        int iC = v.e.c(bVar.f12166p.f12199y);
        if (iC == 2) {
            i = 15;
        } else if (iC == 3) {
            i = 16;
        } else if (iC == 4) {
            i = 17;
        } else if (iC == 5) {
            i = 18;
        } else if (iC == 16) {
            i = 13;
        }
        int i10 = i0.e.f6165a;
        if (Build.VERSION.SDK_INT >= 29) {
            i0.a.d(aVar, i != 0 ? i0.a.b(i) : null);
        } else if (i != 0) {
            switch (v.e.c(i)) {
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    mode = PorterDuff.Mode.CLEAR;
                    break;
                case 1:
                    mode = PorterDuff.Mode.SRC;
                    break;
                case 2:
                    mode = PorterDuff.Mode.DST;
                    break;
                case 3:
                    mode = PorterDuff.Mode.SRC_OVER;
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    mode = PorterDuff.Mode.DST_OVER;
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    mode = PorterDuff.Mode.SRC_IN;
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    mode = PorterDuff.Mode.DST_IN;
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    mode = PorterDuff.Mode.SRC_OUT;
                    break;
                case 8:
                    mode = PorterDuff.Mode.DST_OUT;
                    break;
                case 9:
                    mode = PorterDuff.Mode.SRC_ATOP;
                    break;
                case 10:
                    mode = PorterDuff.Mode.DST_ATOP;
                    break;
                case 11:
                    mode = PorterDuff.Mode.XOR;
                    break;
                case 12:
                    mode = PorterDuff.Mode.ADD;
                    break;
                case 13:
                    mode = PorterDuff.Mode.MULTIPLY;
                    break;
                case 14:
                    mode = PorterDuff.Mode.SCREEN;
                    break;
                case 15:
                    mode = PorterDuff.Mode.OVERLAY;
                    break;
                case 16:
                    mode = PorterDuff.Mode.DARKEN;
                    break;
                case 17:
                    mode = PorterDuff.Mode.LIGHTEN;
                    break;
                default:
                    mode = null;
                    break;
            }
            aVar.setXfermode(mode != null ? new PorterDuffXfermode(mode) : null);
        } else {
            aVar.setXfermode(null);
        }
        path.setFillType(lVar.f11840b);
        o5.e eVarD02 = aVar3.D0();
        this.f8726g = (o5.f) eVarD02;
        eVarD02.a(this);
        bVar.d(eVarD02);
        o5.e eVarD03 = aVar2.D0();
        this.f8727h = (o5.f) eVarD03;
        eVarD03.a(this);
        bVar.d(eVarD03);
    }

    @Override // n5.e
    public final void a(RectF rectF, Matrix matrix, boolean z2) {
        Path path = this.f8721a;
        path.reset();
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f;
            if (i >= arrayList.size()) {
                path.computeBounds(rectF, false);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                return;
            } else {
                path.addPath(((m) arrayList.get(i)).f(), matrix);
                i++;
            }
        }
    }

    @Override // o5.a
    public final void b() {
        this.f8728j.invalidateSelf();
    }

    @Override // n5.c
    public final void c(List list, List list2) {
        for (int i = 0; i < list2.size(); i++) {
            c cVar = (c) list2.get(i);
            if (cVar instanceof m) {
                this.f.add((m) cVar);
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // n5.e
    public final void e(Canvas canvas, Matrix matrix, int i) {
        BlurMaskFilter blurMaskFilter;
        if (this.f8725e) {
            return;
        }
        o5.f fVar = this.f8726g;
        int iK = fVar.k(fVar.f9377c.k(), fVar.c());
        PointF pointF = x5.f.f14266a;
        int i10 = 0;
        int iMax = (Math.max(0, Math.min(255, (int) ((((i / 255.0f) * ((Integer) this.f8727h.e()).intValue()) / 100.0f) * 255.0f))) << 24) | (iK & 16777215);
        m5.a aVar = this.f8722b;
        aVar.setColor(iMax);
        o5.r rVar = this.i;
        if (rVar != null) {
            aVar.setColorFilter((ColorFilter) rVar.e());
        }
        o5.e eVar = this.f8729k;
        if (eVar != null) {
            float fFloatValue = ((Float) eVar.e()).floatValue();
            if (fFloatValue == 0.0f) {
                aVar.setMaskFilter(null);
            } else if (fFloatValue != this.f8730l) {
                t5.b bVar = this.f8723c;
                if (bVar.A == fFloatValue) {
                    blurMaskFilter = bVar.B;
                } else {
                    BlurMaskFilter blurMaskFilter2 = new BlurMaskFilter(fFloatValue / 2.0f, BlurMaskFilter.Blur.NORMAL);
                    bVar.B = blurMaskFilter2;
                    bVar.A = fFloatValue;
                    blurMaskFilter = blurMaskFilter2;
                }
                aVar.setMaskFilter(blurMaskFilter);
            }
            this.f8730l = fFloatValue;
        }
        o5.h hVar = this.f8731m;
        if (hVar != null) {
            hVar.a(aVar);
        }
        Path path = this.f8721a;
        path.reset();
        while (true) {
            ArrayList arrayList = this.f;
            if (i10 >= arrayList.size()) {
                canvas.drawPath(path, aVar);
                return;
            } else {
                path.addPath(((m) arrayList.get(i10)).f(), matrix);
                i10++;
            }
        }
    }

    @Override // q5.f
    public final void g(q5.e eVar, int i, ArrayList arrayList, q5.e eVar2) {
        x5.f.f(eVar, i, arrayList, eVar2, this);
    }

    @Override // n5.c
    public final String getName() {
        return this.f8724d;
    }

    @Override // q5.f
    public final void h(Object obj, p2.c cVar) {
        PointF pointF = z.f7929a;
        if (obj == 1) {
            this.f8726g.j(cVar);
            return;
        }
        if (obj == 4) {
            this.f8727h.j(cVar);
            return;
        }
        ColorFilter colorFilter = z.F;
        t5.b bVar = this.f8723c;
        if (obj == colorFilter) {
            o5.r rVar = this.i;
            if (rVar != null) {
                bVar.p(rVar);
            }
            o5.r rVar2 = new o5.r(null, cVar);
            this.i = rVar2;
            rVar2.a(this);
            bVar.d(this.i);
            return;
        }
        if (obj == z.f7933e) {
            o5.e eVar = this.f8729k;
            if (eVar != null) {
                eVar.j(cVar);
                return;
            }
            o5.r rVar3 = new o5.r(null, cVar);
            this.f8729k = rVar3;
            rVar3.a(this);
            bVar.d(this.f8729k);
            return;
        }
        o5.h hVar = this.f8731m;
        if (obj == 5 && hVar != null) {
            hVar.f9384b.j(cVar);
            return;
        }
        if (obj == z.B && hVar != null) {
            hVar.c(cVar);
            return;
        }
        if (obj == z.C && hVar != null) {
            hVar.f9386d.j(cVar);
            return;
        }
        if (obj == z.D && hVar != null) {
            hVar.f9387e.j(cVar);
        } else {
            if (obj != z.E || hVar == null) {
                return;
            }
            hVar.f.j(cVar);
        }
    }
}
