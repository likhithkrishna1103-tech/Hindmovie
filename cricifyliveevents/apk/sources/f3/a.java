package f3;

import a3.j;
import a3.q;
import a3.t;
import a3.v;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.ImageView;
import androidx.fragment.app.d;
import androidx.media3.decoder.DecoderInputBuffer;
import b2.g;
import bf.f;
import com.google.android.gms.internal.measurement.j4;
import com.google.android.gms.internal.measurement.o4;
import d8.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import k4.b0;
import k4.l0;
import k4.s;
import nc.i;
import nc.l;
import o.n1;
import s2.e0;
import s2.f0;
import s2.g0;
import s2.h0;
import s2.y;
import t0.m0;
import ta.k;
import ua.c0;
import ua.e1;
import ua.j0;
import ua.k0;
import v1.p;
import y1.a0;
import y1.h;
import ya.r;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class a implements j, r {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3934v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3935w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f3936x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f3937y;

    public /* synthetic */ a() {
        this.f3934v = 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x022c, code lost:
    
        if (r19 == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x022e, code lost:
    
        r0 = new i2.k();
        r0.f6085v = new int[]{r5, r11, r12};
        r0.f6086w = new float[]{0.0f, 0.5f, 1.0f};
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0242, code lost:
    
        r0 = new i2.k();
        r0.f6085v = new int[]{r5, r12};
        r15 = 2;
        r0.f6086w = new float[]{0.0f, 1.0f};
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0256, code lost:
    
        if (r9 == r8) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0258, code lost:
    
        if (r9 == r15) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x025a, code lost:
    
        r17 = (int[]) r0.f6085v;
        r18 = (float[]) r0.f6086w;
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
    
        r12 = new android.graphics.SweepGradient(r7, r10, (int[]) r0.f6085v, (float[]) r0.f6086w);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0293, code lost:
    
        if (r25 <= 0.0f) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0295, code lost:
    
        r21 = (int[]) r0.f6085v;
        r22 = (float[]) r0.f6086w;
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
    
        return new f3.a(r12, (android.content.res.ColorStateList) null, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02ce, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01ed, code lost:
    
        if (r2.size() <= 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01ef, code lost:
    
        r0 = new i2.k();
        r1 = r2.size();
        r0.f6085v = new int[r1];
        r0.f6086w = new float[r1];
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0201, code lost:
    
        if (r3 >= r1) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0203, code lost:
    
        ((int[]) r0.f6085v)[r3] = ((java.lang.Integer) r2.get(r3)).intValue();
        ((float[]) r0.f6086w)[r3] = ((java.lang.Float) r13.get(r3)).floatValue();
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
    public static f3.a d(android.content.res.Resources r27, int r28, android.content.res.Resources.Theme r29) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 778
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.a.d(android.content.res.Resources, int, android.content.res.Resources$Theme):f3.a");
    }

    @Override // ya.r
    public void a(Object obj) {
        b0 b0Var = ((l0) this.f3937y).f7060g;
        Handler handler = b0Var.f6916l;
        s sVar = (s) this.f3936x;
        a0.S(handler, new d(b0Var, sVar, new e(this, this.f3935w, (List) obj, sVar)));
    }

    public void b() {
        kf.j jVar;
        ImageView imageView = (ImageView) this.f3936x;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            n1.a(drawable);
        }
        if (drawable == null || (jVar = (kf.j) this.f3937y) == null) {
            return;
        }
        o.r.e(drawable, jVar, imageView.getDrawableState());
    }

    public k0 c() {
        j0 j0Var = (j0) this.f3937y;
        if (j0Var != null) {
            throw j0Var.a();
        }
        e1 e1VarF = e1.f(this.f3935w, (Object[]) this.f3936x, this);
        j0 j0Var2 = (j0) this.f3937y;
        if (j0Var2 == null) {
            return e1VarF;
        }
        throw j0Var2.a();
    }

    public void e(h hVar) {
        for (h0 h0Var : (CopyOnWriteArrayList) this.f3937y) {
            a0.S(h0Var.f11220a, new i(4, hVar, h0Var.f11221b));
        }
    }

    public void f(int i, p pVar, int i10, Object obj, long j4) {
        e(new androidx.fragment.app.e(24, this, new y(1, i, pVar, i10, obj, a0.b0(j4), -9223372036854775807L)));
    }

    public long h(q qVar) {
        int i;
        t tVar = (t) this.f3937y;
        v vVar = (v) this.f3936x;
        while (qVar.x() < qVar.getLength() - 6) {
            int i10 = this.f3935w;
            long jX = qVar.x();
            byte[] bArr = new byte[2];
            int i11 = 0;
            boolean zB = false;
            qVar.z(bArr, 0, 2);
            if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i10) {
                qVar.k();
                qVar.A((int) (jX - qVar.getPosition()));
            } else {
                y1.t tVar2 = new y1.t(16);
                System.arraycopy(bArr, 0, tVar2.f14609a, 0, 2);
                byte[] bArr2 = tVar2.f14609a;
                while (i11 < 14 && (i = qVar.i(bArr2, 2 + i11, 14 - i11)) != -1) {
                    i11 += i;
                }
                tVar2.I(i11);
                qVar.k();
                qVar.A((int) (jX - qVar.getPosition()));
                zB = a3.b.b(tVar2, vVar, i10, tVar);
            }
            if (zB) {
                break;
            }
            qVar.A(1);
        }
        if (qVar.x() < qVar.getLength() - 6) {
            return tVar.f227a;
        }
        qVar.A((int) (qVar.getLength() - qVar.x()));
        return vVar.f238j;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
    @Override // a3.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a3.i i(a3.q r23, long r24) {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.a.i(a3.q, long):a3.i");
    }

    @Override // a3.j
    public void j() {
        switch (this.f3934v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            default:
                y1.t tVar = (y1.t) this.f3937y;
                byte[] bArr = a0.f14553c;
                tVar.getClass();
                tVar.H(bArr.length, bArr);
                break;
        }
    }

    public Object k(int i) {
        SparseArray sparseArray = (SparseArray) this.f3936x;
        if (this.f3935w == -1) {
            this.f3935w = 0;
        }
        while (true) {
            int i10 = this.f3935w;
            if (i10 <= 0 || i >= sparseArray.keyAt(i10)) {
                break;
            }
            this.f3935w--;
        }
        while (this.f3935w < sparseArray.size() - 1 && i >= sparseArray.keyAt(this.f3935w + 1)) {
            this.f3935w++;
        }
        return sparseArray.valueAt(this.f3935w);
    }

    public String l() {
        StringBuilder sb = new StringBuilder("$");
        int i = this.f3935w + 1;
        for (int i10 = 0; i10 < i; i10++) {
            Object obj = ((Object[]) this.f3936x)[i10];
            if (obj instanceof bf.d) {
                bf.d dVar = (bf.d) obj;
                if (!ge.i.a(dVar.c(), f.f1915e)) {
                    int i11 = ((int[]) this.f3937y)[i10];
                    if (i11 >= 0) {
                        sb.append(".");
                        sb.append(dVar.e(i11));
                    }
                } else if (((int[]) this.f3937y)[i10] != -1) {
                    sb.append("[");
                    sb.append(((int[]) this.f3937y)[i10]);
                    sb.append("]");
                }
            } else if (obj != ff.j.f4585a) {
                sb.append("['");
                sb.append(obj);
                sb.append("']");
            }
        }
        String string = sb.toString();
        ge.i.d(string, "toString(...)");
        return string;
    }

    public boolean m() {
        ColorStateList colorStateList;
        return ((Shader) this.f3936x) == null && (colorStateList = (ColorStateList) this.f3937y) != null && colorStateList.isStateful();
    }

    public void n(s2.t tVar, int i, int i10, p pVar, int i11, Object obj, long j4, long j7) {
        e(new f0(this, tVar, new y(i, i10, pVar, i11, obj, a0.b0(j4), a0.b0(j7)), 1));
    }

    public void o(s2.t tVar, int i, int i10, p pVar, int i11, Object obj, long j4, long j7) {
        e(new f0(this, tVar, new y(i, i10, pVar, i11, obj, a0.b0(j4), a0.b0(j7)), 0));
    }

    public void p(s2.t tVar, int i, int i10, p pVar, int i11, Object obj, long j4, long j7, IOException iOException, boolean z10) {
        e(new g0(this, tVar, new y(i, i10, pVar, i11, obj, a0.b0(j4), a0.b0(j7)), iOException, z10));
    }

    public void q(s2.t tVar, int i, IOException iOException, boolean z10) {
        p(tVar, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, z10);
    }

    public void r(AttributeSet attributeSet, int i) {
        int resourceId;
        ImageView imageView = (ImageView) this.f3936x;
        l7.a aVarF = l7.a.F(imageView.getContext(), attributeSet, g.j.AppCompatImageView, i);
        TypedArray typedArray = (TypedArray) aVarF.f7867x;
        m0.m(imageView, imageView.getContext(), g.j.AppCompatImageView, attributeSet, (TypedArray) aVarF.f7867x, i);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (resourceId = typedArray.getResourceId(g.j.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = j4.i(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                n1.a(drawable);
            }
            if (typedArray.hasValue(g.j.AppCompatImageView_tint)) {
                imageView.setImageTintList(aVarF.r(g.j.AppCompatImageView_tint));
            }
            if (typedArray.hasValue(g.j.AppCompatImageView_tintMode)) {
                imageView.setImageTintMode(n1.c(typedArray.getInt(g.j.AppCompatImageView_tintMode, -1), null));
            }
            aVarF.G();
        } catch (Throwable th) {
            aVarF.G();
            throw th;
        }
    }

    public void s(s2.t tVar, int i, int i10, p pVar, int i11, Object obj, long j4, long j7, int i12) {
        e(new e0(this, tVar, new y(i, i10, pVar, i11, obj, a0.b0(j4), a0.b0(j7)), i12));
    }

    public String toString() {
        switch (this.f3934v) {
            case 1:
                return l();
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                StringBuilder sb = new StringBuilder();
                if (((kf.v) this.f3936x) == kf.v.f7573x) {
                    sb.append("HTTP/1.0");
                } else {
                    sb.append("HTTP/1.1");
                }
                sb.append(' ');
                sb.append(this.f3935w);
                sb.append(' ');
                sb.append((String) this.f3937y);
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public a u(Object obj, Object obj2) {
        int i = (this.f3935w + 1) * 2;
        Object[] objArr = (Object[]) this.f3936x;
        if (i > objArr.length) {
            this.f3936x = Arrays.copyOf(objArr, c0.f(objArr.length, i));
        }
        ua.q.c(obj, obj2);
        Object[] objArr2 = (Object[]) this.f3936x;
        int i10 = this.f3935w;
        int i11 = i10 * 2;
        objArr2[i11] = obj;
        objArr2[i11 + 1] = obj2;
        this.f3935w = i10 + 1;
        return this;
    }

    public a v(Iterable iterable) {
        if (iterable instanceof Collection) {
            int size = (((Collection) iterable).size() + this.f3935w) * 2;
            Object[] objArr = (Object[]) this.f3936x;
            if (size > objArr.length) {
                this.f3936x = Arrays.copyOf(objArr, c0.f(objArr.length, size));
            }
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            u(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public a w(e1 e1Var) {
        return v(e1Var.entrySet());
    }

    public void x(int i) {
        ImageView imageView = (ImageView) this.f3936x;
        if (i != 0) {
            Drawable drawableI = j4.i(imageView.getContext(), i);
            if (drawableI != null) {
                n1.a(drawableI);
            }
            imageView.setImageDrawable(drawableI);
        } else {
            imageView.setImageDrawable(null);
        }
        b();
    }

    public List y(CharSequence charSequence) {
        charSequence.getClass();
        l4.a aVar = (l4.a) this.f3937y;
        aVar.getClass();
        k kVar = new k(aVar, this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (kVar.hasNext()) {
            arrayList.add((String) kVar.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void z(int i, long j4, long j7) {
        y yVar = new y(1, i, null, 3, null, a0.b0(j4), a0.b0(j7));
        s2.c0 c0Var = (s2.c0) this.f3936x;
        c0Var.getClass();
        e(new c8.b(this, c0Var, yVar, 12));
    }

    public /* synthetic */ a(Object obj, int i, String str, int i10) {
        this.f3934v = i10;
        this.f3936x = obj;
        this.f3935w = i;
        this.f3937y = str;
    }

    public a(ImageView imageView) {
        this.f3934v = 7;
        this.f3935w = 0;
        this.f3936x = imageView;
    }

    public a(l lVar) {
        this.f3934v = 10;
        this.f3936x = new SparseArray();
        this.f3937y = lVar;
        this.f3935w = -1;
    }

    public a(Shader shader, ColorStateList colorStateList, int i) {
        this.f3934v = 5;
        this.f3936x = shader;
        this.f3937y = colorStateList;
        this.f3935w = i;
    }

    public a(v vVar, int i) {
        this.f3934v = 0;
        this.f3936x = vVar;
        this.f3935w = i;
        this.f3937y = new t();
    }

    public a(int i, y1.y yVar) {
        this.f3934v = 3;
        this.f3935w = i;
        this.f3936x = yVar;
        this.f3937y = new y1.t();
    }

    public a(g gVar) {
        this.f3934v = 4;
        o4 o4Var = new o4();
        o4Var.f2561w = new x3.e();
        this.f3937y = o4Var;
        this.f3936x = gVar;
        this.f3935w = 1;
    }

    public a(l4.a aVar) {
        this.f3934v = 11;
        this.f3937y = aVar;
        this.f3936x = ta.d.f11957v;
        this.f3935w = Integer.MAX_VALUE;
    }

    private final /* synthetic */ void t() {
    }

    public a(CopyOnWriteArrayList copyOnWriteArrayList, int i, s2.c0 c0Var) {
        this.f3934v = 9;
        this.f3937y = copyOnWriteArrayList;
        this.f3935w = i;
        this.f3936x = c0Var;
    }

    @Override // ya.r
    public void g(Throwable th) {
    }

    public a(int i) {
        this.f3934v = 12;
        this.f3936x = new Object[i * 2];
        this.f3935w = 0;
    }

    public a(l8.i iVar) {
        this.f3934v = 13;
        this.f3937y = t7.d.a(150, new m2.e(this));
        this.f3936x = iVar;
    }

    public a(l0 l0Var, s sVar, int i) {
        this.f3934v = 6;
        this.f3937y = l0Var;
        this.f3936x = sVar;
        this.f3935w = i;
    }
}
