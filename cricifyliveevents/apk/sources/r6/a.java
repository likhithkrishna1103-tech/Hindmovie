package r6;

import a9.l;
import java.io.Closeable;
import java.util.Arrays;
import nb.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Closeable {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String[] f10886z = new String[128];

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10887v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int[] f10888w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String[] f10889x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f10890y;

    static {
        for (int i = 0; i <= 31; i++) {
            f10886z[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f10886z;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public abstract boolean A();

    public abstract boolean C();

    public abstract double J();

    public abstract int O();

    public abstract String Q();

    public abstract int R();

    public abstract void a();

    public final void e0(int i) {
        int i10 = this.f10887v;
        int[] iArr = this.f10888w;
        if (i10 == iArr.length) {
            if (i10 == 256) {
                throw new l("Nesting too deep at " + z());
            }
            this.f10888w = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f10889x;
            this.f10889x = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f10890y;
            this.f10890y = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f10888w;
        int i11 = this.f10887v;
        this.f10887v = i11 + 1;
        iArr3[i11] = i;
    }

    public abstract void g();

    public abstract int g0(w wVar);

    public abstract void h0();

    public abstract void i0();

    public final void j0(String str) throws a2.a {
        throw new a2.a(str + " at path " + z());
    }

    public abstract void q();

    public abstract void s();

    public final String z() {
        int i = this.f10887v;
        int[] iArr = this.f10888w;
        String[] strArr = this.f10889x;
        int[] iArr2 = this.f10890y;
        StringBuilder sb = new StringBuilder("$");
        for (int i10 = 0; i10 < i; i10++) {
            int i11 = iArr[i10];
            if (i11 == 1 || i11 == 2) {
                sb.append('[');
                sb.append(iArr2[i10]);
                sb.append(']');
            } else if (i11 == 3 || i11 == 4 || i11 == 5) {
                sb.append('.');
                String str = strArr[i10];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }
}
