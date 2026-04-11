package w5;

import a2.y0;
import java.io.Closeable;
import java.util.Arrays;
import pb.c;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Closeable {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String[] f13738y = new String[128];

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f13739u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int[] f13740v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String[] f13741w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int[] f13742x;

    static {
        for (int i = 0; i <= 31; i++) {
            f13738y[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f13738y;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public final String F() {
        int i = this.f13739u;
        int[] iArr = this.f13740v;
        String[] strArr = this.f13741w;
        int[] iArr2 = this.f13742x;
        StringBuilder sb2 = new StringBuilder("$");
        for (int i10 = 0; i10 < i; i10++) {
            int i11 = iArr[i10];
            if (i11 == 1 || i11 == 2) {
                sb2.append('[');
                sb2.append(iArr2[i10]);
                sb2.append(']');
            } else if (i11 == 3 || i11 == 4 || i11 == 5) {
                sb2.append('.');
                String str = strArr[i10];
                if (str != null) {
                    sb2.append(str);
                }
            }
        }
        return sb2.toString();
    }

    public abstract boolean G();

    public abstract boolean H();

    public abstract double J();

    public abstract int K();

    public abstract String S();

    public abstract void a();

    public abstract void d();

    public abstract int g0();

    public final void h0(int i) {
        int i10 = this.f13739u;
        int[] iArr = this.f13740v;
        if (i10 == iArr.length) {
            if (i10 == 256) {
                throw new y0("Nesting too deep at " + F());
            }
            this.f13740v = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f13741w;
            this.f13741w = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f13742x;
            this.f13742x = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f13740v;
        int i11 = this.f13739u;
        this.f13739u = i11 + 1;
        iArr3[i11] = i;
    }

    public abstract int i0(c cVar);

    public abstract void j0();

    public abstract void k0();

    public final void l0(String str) throws c6.c {
        throw new c6.c(str + " at path " + F());
    }

    public abstract void v();

    public abstract void x();
}
