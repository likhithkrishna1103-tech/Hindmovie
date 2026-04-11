package z7;

import aa.j0;
import ae.p;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import be.h;
import g4.t;
import ie.n;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.ListIterator;
import ke.o;
import ke.x;
import p1.g0;
import p1.s0;
import p1.w0;
import pe.q;
import q0.u0;
import q1.c;
import r4.v;
import ub.d;
import yc.f;
import yc.g;
import yc.k;
import z9.l;
import z9.m;
import zc.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f14895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f14896b;

    public static float A(int i, float f, int i10, int i11) {
        float f4;
        if (f == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i == 0) {
            f4 = i11;
        } else {
            if (i != 1) {
                if (i != 2) {
                    return -3.4028235E38f;
                }
                return f;
            }
            f4 = i10;
        }
        return f * f4;
    }

    public static TypedValue B(int i, Context context, String str) {
        TypedValue typedValueY = y(context, i);
        if (typedValueY != null) {
            return typedValueY;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    public static void C(w0 w0Var, t tVar) {
        int i = tVar.f5222b;
        long j5 = tVar.f5223c;
        j0 j0Var = tVar.f5221a;
        if (i == -1) {
            if (w0Var.e0(20)) {
                w0Var.Q0(j0Var);
                return;
            } else {
                if (j0Var.isEmpty()) {
                    return;
                }
                w0Var.y((g0) j0Var.get(0));
                return;
            }
        }
        if (w0Var.e0(20)) {
            w0Var.j(j0Var, tVar.f5222b, j5);
        } else {
            if (j0Var.isEmpty()) {
                return;
            }
            w0Var.z((g0) j0Var.get(0), j5);
        }
    }

    public static final Object D(q qVar, q qVar2, p pVar) throws Throwable {
        Object oVar;
        Object objL;
        try {
            be.q.a(2, pVar);
            oVar = pVar.i(qVar2, qVar);
        } catch (Throwable th) {
            oVar = new o(th, false);
        }
        sd.a aVar = sd.a.f11942u;
        if (oVar == aVar || (objL = qVar.L(oVar)) == x.f7744e) {
            return aVar;
        }
        if (objL instanceof o) {
            throw ((o) objL).f7717a;
        }
        return x.o(objL);
    }

    public static byte[] E(d dVar) throws IOException {
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int iMin = Math.min(8192, Math.max(128, Integer.highestOneBit(0) * 2));
        int i = 0;
        while (i < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i);
            byte[] bArr = new byte[iMin2];
            arrayDeque.add(bArr);
            int i10 = 0;
            while (i10 < iMin2) {
                int i11 = dVar.read(bArr, i10, iMin2 - i10);
                if (i11 == -1) {
                    return h(arrayDeque, i);
                }
                i10 += i11;
                i += i11;
            }
            long j5 = ((long) iMin) * ((long) (iMin < 4096 ? 4 : 2));
            iMin = j5 > 2147483647L ? Integer.MAX_VALUE : j5 < -2147483648L ? Integer.MIN_VALUE : (int) j5;
        }
        if (dVar.read() == -1) {
            return h(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    public static final void F(e eVar, e eVar2) {
        h.e(eVar, "<this>");
        h.e(eVar2, "downloadInfo");
        eVar2.f14950u = eVar.f14950u;
        eVar2.h(eVar.f14951v);
        eVar2.j(eVar.f14952w);
        eVar2.g(eVar.f14953x);
        eVar2.f14954y = eVar.f14954y;
        g gVar = eVar.f14955z;
        h.e(gVar, "<set-?>");
        eVar2.f14955z = gVar;
        eVar2.A = od.t.J(eVar.A);
        eVar2.B = eVar.B;
        eVar2.C = eVar.C;
        k kVar = eVar.D;
        h.e(kVar, "<set-?>");
        eVar2.D = kVar;
        f fVar = eVar.F;
        h.e(fVar, "<set-?>");
        eVar2.F = fVar;
        eVar2.e(eVar.E);
        eVar2.G = eVar.G;
        eVar2.H = eVar.H;
        yc.a aVar = eVar.I;
        h.e(aVar, "<set-?>");
        eVar2.I = aVar;
        eVar2.J = eVar.J;
        eVar2.K = eVar.K;
        id.g gVar2 = eVar.L;
        h.e(gVar2, "<set-?>");
        eVar2.L = gVar2;
        eVar2.M = eVar.M;
        eVar2.N = eVar.N;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean d(int r8, android.graphics.Rect r9, android.graphics.Rect r10, android.graphics.Rect r11) {
        /*
            boolean r0 = e(r8, r9, r10)
            boolean r1 = e(r8, r9, r11)
            if (r1 != 0) goto L75
            if (r0 != 0) goto Le
            goto L75
        Le:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r2 = 33
            r3 = 66
            r4 = 17
            r5 = 1
            if (r8 == r4) goto L3c
            if (r8 == r2) goto L35
            if (r8 == r3) goto L2e
            if (r8 != r1) goto L28
            int r6 = r9.bottom
            int r7 = r11.top
            if (r6 > r7) goto L74
            goto L42
        L28:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r0)
            throw r8
        L2e:
            int r6 = r9.right
            int r7 = r11.left
            if (r6 > r7) goto L74
            goto L42
        L35:
            int r6 = r9.top
            int r7 = r11.bottom
            if (r6 < r7) goto L74
            goto L42
        L3c:
            int r6 = r9.left
            int r7 = r11.right
            if (r6 < r7) goto L74
        L42:
            if (r8 == r4) goto L74
            if (r8 != r3) goto L47
            goto L74
        L47:
            int r10 = s(r8, r9, r10)
            if (r8 == r4) goto L69
            if (r8 == r2) goto L64
            if (r8 == r3) goto L5f
            if (r8 != r1) goto L59
            int r8 = r11.bottom
            int r9 = r9.bottom
        L57:
            int r8 = r8 - r9
            goto L6e
        L59:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r0)
            throw r8
        L5f:
            int r8 = r11.right
            int r9 = r9.right
            goto L57
        L64:
            int r8 = r9.top
            int r9 = r11.top
            goto L57
        L69:
            int r8 = r9.left
            int r9 = r11.left
            goto L57
        L6e:
            int r8 = java.lang.Math.max(r5, r8)
            if (r10 >= r8) goto L75
        L74:
            return r5
        L75:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: z7.a.d(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static boolean e(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static void f(int i, int i10, int i11) {
        if (i < 0 || i10 > i11) {
            StringBuilder sbP = l4.a.p(i, i10, "fromIndex: ", ", toIndex: ", ", size: ");
            sbP.append(i11);
            throw new IndexOutOfBoundsException(sbP.toString());
        }
        if (i > i10) {
            throw new IllegalArgumentException(l4.a.l(i, i10, "fromIndex: ", " > toIndex: "));
        }
    }

    public static byte g(long j5) {
        c.f(j5, "out of range: %s", (j5 >> 8) == 0);
        return (byte) j5;
    }

    public static byte[] h(ArrayDeque arrayDeque, int i) {
        if (arrayDeque.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) arrayDeque.remove();
        if (bArr.length == i) {
            return bArr;
        }
        int length = i - bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i);
        while (length > 0) {
            byte[] bArr2 = (byte[]) arrayDeque.remove();
            int iMin = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, bArrCopyOf, i - length, iMin);
            length -= iMin;
        }
        return bArrCopyOf;
    }

    public static final long i() {
        return Thread.currentThread().getId();
    }

    public static final void j(y4.a aVar) throws Exception {
        h.e(aVar, "connection");
        pd.c cVarN = android.support.v4.media.session.b.n();
        y4.c cVarE0 = aVar.e0("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cVarE0.W()) {
            try {
                cVarN.add(cVarE0.j(0));
            } finally {
            }
        }
        cf.d.g(cVarE0, null);
        ListIterator listIterator = android.support.v4.media.session.b.c(cVarN).listIterator(0);
        while (true) {
            pd.a aVar2 = (pd.a) listIterator;
            if (!aVar2.hasNext()) {
                return;
            }
            String str = (String) aVar2.next();
            if (n.M(str, "room_fts_content_sync_", false)) {
                android.support.v4.media.session.b.o(aVar, "DROP TRIGGER IF EXISTS ".concat(str));
            }
        }
    }

    public static View k(View view, int i) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View viewFindViewById = viewGroup.getChildAt(i10).findViewById(i);
            if (viewFindViewById != null) {
                return viewFindViewById;
            }
        }
        return null;
    }

    public static int l(Context context, int i, int i10) {
        Integer numValueOf;
        TypedValue typedValueY = y(context, i);
        if (typedValueY != null) {
            int i11 = typedValueY.resourceId;
            numValueOf = Integer.valueOf(i11 != 0 ? context.getColor(i11) : typedValueY.data);
        } else {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : i10;
    }

    public static int m(View view, int i) {
        Context context = view.getContext();
        TypedValue typedValueB = B(i, view.getContext(), view.getClass().getCanonicalName());
        int i10 = typedValueB.resourceId;
        return i10 != 0 ? context.getColor(i10) : typedValueB.data;
    }

    public static s0 n(s0 s0Var, s0 s0Var2) {
        if (s0Var != null) {
            p1.o oVar = s0Var.f10058a;
            if (s0Var2 != null) {
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
                for (int i = 0; i < oVar.f9953a.size(); i++) {
                    if (s0Var2.a(oVar.b(i))) {
                        int iB = oVar.b(i);
                        s1.d.g(!false);
                        sparseBooleanArray.append(iB, true);
                    }
                }
                s1.d.g(!false);
                return new s0(new p1.o(sparseBooleanArray));
            }
        }
        return s0.f10056b;
    }

    public static boolean o(int i, Rect rect, Rect rect2) {
        if (i == 17) {
            int i10 = rect.right;
            int i11 = rect2.right;
            return (i10 > i11 || rect.left >= i11) && rect.left > rect2.left;
        }
        if (i == 33) {
            int i12 = rect.bottom;
            int i13 = rect2.bottom;
            return (i12 > i13 || rect.top >= i13) && rect.top > rect2.top;
        }
        if (i == 66) {
            int i14 = rect.left;
            int i15 = rect2.left;
            return (i14 < i15 || rect.right <= i15) && rect.right < rect2.right;
        }
        if (i != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i16 = rect.top;
        int i17 = rect2.top;
        return (i16 < i17 || rect.bottom <= i17) && rect.bottom < rect2.bottom;
    }

    public static boolean p(int i) {
        if (i == 0) {
            return false;
        }
        ThreadLocal threadLocal = i0.b.f6159a;
        double[] dArr = (double[]) threadLocal.get();
        if (dArr == null) {
            dArr = new double[3];
            threadLocal.set(dArr);
        }
        int iRed = Color.red(i);
        int iGreen = Color.green(i);
        int iBlue = Color.blue(i);
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d10 = ((double) iRed) / 255.0d;
        double dPow = d10 < 0.04045d ? d10 / 12.92d : Math.pow((d10 + 0.055d) / 1.055d, 2.4d);
        double d11 = ((double) iGreen) / 255.0d;
        double dPow2 = d11 < 0.04045d ? d11 / 12.92d : Math.pow((d11 + 0.055d) / 1.055d, 2.4d);
        double d12 = ((double) iBlue) / 255.0d;
        double dPow3 = d12 < 0.04045d ? d12 / 12.92d : Math.pow((d12 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.1805d * dPow3) + (0.3576d * dPow2) + (0.4124d * dPow)) * 100.0d;
        double d13 = ((0.0722d * dPow3) + (0.7152d * dPow2) + (0.2126d * dPow)) * 100.0d;
        dArr[1] = d13;
        dArr[2] = ((dPow3 * 0.9505d) + (dPow2 * 0.1192d) + (dPow * 0.0193d)) * 100.0d;
        return d13 / 100.0d > 0.5d;
    }

    public static synchronized boolean q(Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f14895a;
        if (context2 != null && (bool = f14896b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f14896b = null;
        if (x7.b.d()) {
            f14896b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f14896b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f14896b = Boolean.FALSE;
            }
        }
        f14895a = applicationContext;
        return f14896b.booleanValue();
    }

    public static int r(float f, int i, int i10) {
        return i0.b.b(i0.b.d(i10, Math.round(Color.alpha(i10) * f)), i);
    }

    public static int s(int i, Rect rect, Rect rect2) {
        int i10;
        int i11;
        if (i == 17) {
            i10 = rect.left;
            i11 = rect2.right;
        } else if (i == 33) {
            i10 = rect.top;
            i11 = rect2.bottom;
        } else if (i == 66) {
            i10 = rect2.left;
            i11 = rect.right;
        } else {
            if (i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i10 = rect2.top;
            i11 = rect.bottom;
        }
        return Math.max(0, i10 - i11);
    }

    public static l t(l lVar) {
        return ((lVar instanceof z9.n) || (lVar instanceof m)) ? lVar : lVar instanceof Serializable ? new m(lVar) : new z9.n(lVar);
    }

    public static int u(int i, Rect rect, Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    public static final Object v(r4.t tVar, boolean z2, boolean z10, ae.l lVar) {
        h.e(tVar, "db");
        tVar.a();
        tVar.b();
        return b8.h.z(new w4.b(lVar, tVar, null, z10, z2));
    }

    public static final Cursor w(r4.t tVar, v vVar) {
        h.e(tVar, "db");
        tVar.a();
        tVar.b();
        return tVar.h().Z().p(vVar);
    }

    public static void x(r1.a aVar) {
        aVar.f11237k = -3.4028235E38f;
        aVar.f11236j = Integer.MIN_VALUE;
        CharSequence charSequence = aVar.f11229a;
        if (charSequence instanceof Spanned) {
            if (!(charSequence instanceof Spannable)) {
                aVar.f11229a = SpannableString.valueOf(charSequence);
                aVar.f11230b = null;
            }
            CharSequence charSequence2 = aVar.f11229a;
            charSequence2.getClass();
            Spannable spannable = (Spannable) charSequence2;
            for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
                if ((obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan)) {
                    spannable.removeSpan(obj);
                }
            }
        }
    }

    public static TypedValue y(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean z(Context context, int i, boolean z2) {
        TypedValue typedValueY = y(context, i);
        return (typedValueY == null || typedValueY.type != 18) ? z2 : typedValueY.data != 0;
    }

    @Override // q0.u0
    public void b() {
    }

    @Override // q0.u0
    public void c() {
    }
}
