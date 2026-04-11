package aa;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.ImageView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import n.d3;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class l0 implements w2.j, ea.s {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f704u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f705v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f706w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f707x;

    public /* synthetic */ l0() {
        this.f704u = 11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x022c, code lost:
    
        if (r19 == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x022e, code lost:
    
        r0 = new com.google.android.gms.internal.measurement.k4();
        r0.f3070u = new int[]{r5, r11, r12};
        r0.f3071v = new float[]{0.0f, 0.5f, 1.0f};
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0242, code lost:
    
        r0 = new com.google.android.gms.internal.measurement.k4();
        r0.f3070u = new int[]{r5, r12};
        r15 = 2;
        r0.f3071v = new float[]{0.0f, 1.0f};
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0256, code lost:
    
        if (r9 == r8) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0258, code lost:
    
        if (r9 == r15) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x025a, code lost:
    
        r17 = (int[]) r0.f3070u;
        r18 = (float[]) r0.f3071v;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0268, code lost:
    
        if (r6 == r8) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x026a, code lost:
    
        if (r6 == r15) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x026c, code lost:
    
        r0 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0277, code lost:
    
        r0 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x027a, code lost:
    
        r0 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x027d, code lost:
    
        r12 = new android.graphics.LinearGradient(r21, r22, r26, r16, r17, r18, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0281, code lost:
    
        r12 = new android.graphics.SweepGradient(r7, r10, (int[]) r0.f3070u, (float[]) r0.f3071v);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0293, code lost:
    
        if (r25 <= 0.0f) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0295, code lost:
    
        r21 = (int[]) r0.f3070u;
        r22 = (float[]) r0.f3071v;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02a5, code lost:
    
        if (r6 == 1) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x02a7, code lost:
    
        if (r6 == 2) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02a9, code lost:
    
        r0 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x02b4, code lost:
    
        r0 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02b7, code lost:
    
        r0 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02ba, code lost:
    
        r12 = new android.graphics.RadialGradient(r7, r10, r25, r21, r22, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02c6, code lost:
    
        return new aa.l0(r12, (android.content.res.ColorStateList) null, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02ce, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01ed, code lost:
    
        if (r2.size() <= 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01ef, code lost:
    
        r0 = new com.google.android.gms.internal.measurement.k4();
        r1 = r2.size();
        r0.f3070u = new int[r1];
        r0.f3071v = new float[r1];
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0201, code lost:
    
        if (r3 >= r1) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0203, code lost:
    
        ((int[]) r0.f3070u)[r3] = ((java.lang.Integer) r2.get(r3)).intValue();
        ((float[]) r0.f3071v)[r3] = ((java.lang.Float) r13.get(r3)).floatValue();
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0226, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0227, code lost:
    
        if (r0 == null) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0229, code lost:
    
        r8 = 1;
        r15 = 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static aa.l0 e(android.content.res.Resources r27, int r28, android.content.res.Resources.Theme r29) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 778
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: aa.l0.e(android.content.res.Resources, int, android.content.res.Resources$Theme):aa.l0");
    }

    public void a() {
        d3 d3Var;
        ImageView imageView = (ImageView) this.f706w;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            n.n1.a(drawable);
        }
        if (drawable == null || (d3Var = (d3) this.f707x) == null) {
            return;
        }
        n.t.e(drawable, d3Var, imageView.getDrawableState());
    }

    public qb.b b() {
        if (!"".isEmpty()) {
            throw new IllegalStateException("Missing required properties:".concat(""));
        }
        String str = (String) this.f706w;
        return new qb.b(this.f705v, ((Long) this.f707x).longValue(), str);
    }

    @Override // ea.s
    public void c(Object obj) {
        g4.b0 b0Var = ((g4.m0) this.f707x).f5115g;
        Handler handler = b0Var.f4965l;
        g4.s sVar = (g4.s) this.f706w;
        s1.b0.S(handler, new a2.g0(b0Var, sVar, new dd.l(this, this.f705v, (List) obj, sVar)));
    }

    public m0 d() {
        h1 h1Var;
        k0 k0Var = (k0) this.f707x;
        if (k0Var != null) {
            throw k0Var.a();
        }
        int i = this.f705v;
        Object[] objArrCopyOf = (Object[]) this.f706w;
        if (i == 0) {
            h1Var = h1.A;
        } else if (i == 1) {
            Objects.requireNonNull(objArrCopyOf[0]);
            Objects.requireNonNull(objArrCopyOf[1]);
            h1Var = new h1(null, objArrCopyOf, 1);
        } else {
            q1.c.k(i, objArrCopyOf.length >> 1);
            Object objF = h1.f(objArrCopyOf, i, o0.l(i), 0);
            if (objF instanceof Object[]) {
                Object[] objArr = (Object[]) objF;
                this.f707x = (k0) objArr[2];
                Object obj = objArr[0];
                int iIntValue = ((Integer) objArr[1]).intValue();
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue * 2);
                objF = obj;
                i = iIntValue;
            }
            h1Var = new h1(objF, objArrCopyOf, i);
        }
        k0 k0Var2 = (k0) this.f707x;
        if (k0Var2 == null) {
            return h1Var;
        }
        throw k0Var2.a();
    }

    public void f(s1.h hVar) {
        for (o2.j0 j0Var : (CopyOnWriteArrayList) this.f707x) {
            s1.b0.S(j0Var.f9146a, new o2.i0(hVar, 0, j0Var.f9147b));
        }
    }

    public void g(int i, p1.q qVar, int i10, Object obj, long j5) {
        f(new b2.b(this, 17, new o2.z(1, i, qVar, i10, obj, s1.b0.b0(j5), -9223372036854775807L)));
    }

    public long h(w2.p pVar) {
        int i;
        w2.s sVar = (w2.s) this.f707x;
        w2.u uVar = (w2.u) this.f706w;
        while (pVar.s() < pVar.getLength() - 6) {
            int i10 = this.f705v;
            long jS = pVar.s();
            byte[] bArr = new byte[2];
            int i11 = 0;
            boolean zC = false;
            pVar.w(bArr, 0, 2);
            if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i10) {
                pVar.l();
                pVar.B((int) (jS - pVar.getPosition()));
            } else {
                s1.u uVar2 = new s1.u(16);
                System.arraycopy(bArr, 0, uVar2.f11709a, 0, 2);
                byte[] bArr2 = uVar2.f11709a;
                while (i11 < 14 && (i = pVar.i(bArr2, 2 + i11, 14 - i11)) != -1) {
                    i11 += i;
                }
                uVar2.I(i11);
                pVar.l();
                pVar.B((int) (jS - pVar.getPosition()));
                zC = w2.b.c(uVar2, uVar, i10, sVar);
            }
            if (zC) {
                break;
            }
            pVar.B(1);
        }
        if (pVar.s() < pVar.getLength() - 6) {
            return sVar.f13664a;
        }
        pVar.B((int) (pVar.getLength() - pVar.s()));
        return uVar.f13675j;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
    @Override // w2.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public w2.i i(w2.p r23, long r24) {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: aa.l0.i(w2.p, long):w2.i");
    }

    public Object j(int i) {
        SparseArray sparseArray = (SparseArray) this.f706w;
        if (this.f705v == -1) {
            this.f705v = 0;
        }
        while (true) {
            int i10 = this.f705v;
            if (i10 <= 0 || i >= sparseArray.keyAt(i10)) {
                break;
            }
            this.f705v--;
        }
        while (this.f705v < sparseArray.size() - 1 && i >= sparseArray.keyAt(this.f705v + 1)) {
            this.f705v++;
        }
        return sparseArray.valueAt(this.f705v);
    }

    @Override // w2.j
    public void k() {
        switch (this.f704u) {
            case 2:
                break;
            default:
                s1.u uVar = (s1.u) this.f707x;
                byte[] bArr = s1.b0.f11649c;
                uVar.getClass();
                uVar.H(bArr.length, bArr);
                break;
        }
    }

    public boolean l() {
        ColorStateList colorStateList;
        return ((Shader) this.f706w) == null && (colorStateList = (ColorStateList) this.f707x) != null && colorStateList.isStateful();
    }

    public void m(o2.u uVar, int i, int i10, p1.q qVar, int i11, Object obj, long j5, long j8) {
        f(new o2.g0(this, uVar, new o2.z(i, i10, qVar, i11, obj, s1.b0.b0(j5), s1.b0.b0(j8)), 1));
    }

    public void n(o2.u uVar, int i) {
        o(uVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    public void o(o2.u uVar, int i, int i10, p1.q qVar, int i11, Object obj, long j5, long j8) {
        f(new o2.g0(this, uVar, new o2.z(i, i10, qVar, i11, obj, s1.b0.b0(j5), s1.b0.b0(j8)), 0));
    }

    public void q(o2.u uVar, int i, int i10, p1.q qVar, int i11, Object obj, long j5, long j8, IOException iOException, boolean z2) {
        f(new o2.h0(this, uVar, new o2.z(i, i10, qVar, i11, obj, s1.b0.b0(j5), s1.b0.b0(j8)), iOException, z2));
    }

    public void r(o2.u uVar, int i, IOException iOException, boolean z2) {
        q(uVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, z2);
    }

    public void s(AttributeSet attributeSet, int i) {
        int resourceId;
        ImageView imageView = (ImageView) this.f706w;
        kc.b bVarD = kc.b.D(imageView.getContext(), attributeSet, g.j.AppCompatImageView, i);
        TypedArray typedArray = (TypedArray) bVarD.f7621w;
        q0.o0.m(imageView, imageView.getContext(), g.j.AppCompatImageView, attributeSet, (TypedArray) bVarD.f7621w, i);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (resourceId = typedArray.getResourceId(g.j.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = com.bumptech.glide.d.p(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                n.n1.a(drawable);
            }
            if (typedArray.hasValue(g.j.AppCompatImageView_tint)) {
                imageView.setImageTintList(bVarD.q(g.j.AppCompatImageView_tint));
            }
            if (typedArray.hasValue(g.j.AppCompatImageView_tintMode)) {
                imageView.setImageTintMode(n.n1.b(typedArray.getInt(g.j.AppCompatImageView_tintMode, -1), null));
            }
            bVarD.E();
        } catch (Throwable th) {
            bVarD.E();
            throw th;
        }
    }

    public void t(o2.u uVar, int i, int i10, p1.q qVar, int i11, Object obj, long j5, long j8, int i12) {
        f(new o2.f0(this, uVar, new o2.z(i, i10, qVar, i11, obj, s1.b0.b0(j5), s1.b0.b0(j8)), i12));
    }

    public String toString() {
        switch (this.f704u) {
            case 13:
                StringBuilder sb2 = new StringBuilder();
                if (((ue.t) this.f706w) == ue.t.f13046v) {
                    sb2.append("HTTP/1.0");
                } else {
                    sb2.append("HTTP/1.1");
                }
                sb2.append(' ');
                sb2.append(this.f705v);
                sb2.append(' ');
                sb2.append((String) this.f707x);
                String string = sb2.toString();
                be.h.d(string, "StringBuilder().apply(builderAction).toString()");
                return string;
            default:
                return super.toString();
        }
    }

    public l0 v(Object obj, Object obj2) {
        int i = (this.f705v + 1) * 2;
        Object[] objArr = (Object[]) this.f706w;
        if (i > objArr.length) {
            this.f706w = Arrays.copyOf(objArr, d0.f(objArr.length, i));
        }
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 == null) {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
        Object[] objArr2 = (Object[]) this.f706w;
        int i10 = this.f705v;
        int i11 = i10 * 2;
        objArr2[i11] = obj;
        objArr2[i11 + 1] = obj2;
        this.f705v = i10 + 1;
        return this;
    }

    public void w(int i) {
        ImageView imageView = (ImageView) this.f706w;
        if (i != 0) {
            Drawable drawableP = com.bumptech.glide.d.p(imageView.getContext(), i);
            if (drawableP != null) {
                n.n1.a(drawableP);
            }
            imageView.setImageDrawable(drawableP);
        } else {
            imageView.setImageDrawable(null);
        }
        a();
    }

    public List x(CharSequence charSequence) {
        charSequence.getClass();
        q0.e eVar = (q0.e) this.f707x;
        eVar.getClass();
        z9.k kVar = new z9.k(eVar, this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (kVar.hasNext()) {
            arrayList.add((String) kVar.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void y(int i, long j5, long j8) {
        o2.z zVar = new o2.z(1, i, null, 3, null, s1.b0.b0(j5), s1.b0.b0(j8));
        o2.d0 d0Var = (o2.d0) this.f706w;
        d0Var.getClass();
        f(new dd.e(this, d0Var, zVar, 8));
    }

    public /* synthetic */ l0(Object obj, int i, String str, int i10) {
        this.f704u = i10;
        this.f706w = obj;
        this.f705v = i;
        this.f707x = str;
    }

    public l0(ImageView imageView) {
        this.f704u = 8;
        this.f705v = 0;
        this.f706w = imageView;
    }

    public l0(ia.b bVar) {
        this.f704u = 10;
        this.f706w = new SparseArray();
        this.f707x = bVar;
        this.f705v = -1;
    }

    public l0(Shader shader, ColorStateList colorStateList, int i) {
        this.f704u = 7;
        this.f706w = shader;
        this.f707x = colorStateList;
        this.f705v = i;
    }

    public l0(w2.u uVar, int i) {
        this.f704u = 2;
        this.f706w = uVar;
        this.f705v = i;
        this.f707x = new w2.s();
    }

    public l0(int i, s1.z zVar) {
        this.f704u = 4;
        this.f705v = i;
        this.f706w = zVar;
        this.f707x = new s1.u();
    }

    public l0(v1.g gVar) {
        this.f704u = 3;
        e6.f0 f0Var = new e6.f0();
        f0Var.f4499v = new k8.b0(27);
        this.f707x = f0Var;
        this.f706w = gVar;
        this.f705v = 1;
    }

    public l0(q0.e eVar) {
        this.f704u = 12;
        this.f707x = eVar;
        this.f706w = z9.d.f14907u;
        this.f705v = Integer.MAX_VALUE;
    }

    private final /* synthetic */ void u() {
    }

    public l0(CopyOnWriteArrayList copyOnWriteArrayList, int i, o2.d0 d0Var) {
        this.f704u = 9;
        this.f707x = copyOnWriteArrayList;
        this.f705v = i;
        this.f706w = d0Var;
    }

    @Override // ea.s
    public void p(Throwable th) {
    }

    public l0(int i) {
        this.f704u = 0;
        this.f706w = new Object[i * 2];
        this.f705v = 0;
    }

    public l0(q7.h hVar) {
        this.f704u = 5;
        this.f707x = y6.d.a(150, new wb.c(11, this));
        this.f706w = hVar;
    }

    public l0(g4.m0 m0Var, g4.s sVar, int i) {
        this.f704u = 6;
        this.f707x = m0Var;
        this.f706w = sVar;
        this.f705v = i;
    }
}
