package androidx.datastore.preferences.protobuf;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class g implements Iterable, Serializable {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final g f703x = new g(x.f809b);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final e f704y;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f705v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final byte[] f706w;

    static {
        f704y = c.a() ? new e(1) : new e(0);
    }

    public g(byte[] bArr) {
        bArr.getClass();
        this.f706w = bArr;
    }

    public static int b(int i, int i10, int i11) {
        int i12 = i10 - i;
        if ((i | i10 | i12 | (i11 - i10)) >= 0) {
            return i12;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(l0.e.h(i, "Beginning index: ", " < 0"));
        }
        if (i10 < i) {
            throw new IndexOutOfBoundsException(q4.a.m(i, i10, "Beginning index larger than ending index: ", ", "));
        }
        throw new IndexOutOfBoundsException(q4.a.m(i10, i11, "End index: ", " >= "));
    }

    public static g c(byte[] bArr, int i, int i10) {
        byte[] bArrCopyOfRange;
        b(i, i + i10, bArr.length);
        switch (f704y.f695a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i10 + i);
                break;
            default:
                bArrCopyOfRange = new byte[i10];
                System.arraycopy(bArr, i, bArrCopyOfRange, 0, i10);
                break;
        }
        return new g(bArrCopyOfRange);
    }

    public byte a(int i) {
        return this.f706w[i];
    }

    public void d(int i, byte[] bArr) {
        System.arraycopy(this.f706w, 0, bArr, 0, i);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g) || size() != ((g) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof g)) {
            return obj.equals(this);
        }
        g gVar = (g) obj;
        int i = this.f705v;
        int i10 = gVar.f705v;
        if (i != 0 && i10 != 0 && i != i10) {
            return false;
        }
        int size = size();
        if (size > gVar.size()) {
            throw new IllegalArgumentException("Length too large: " + size + size());
        }
        if (size > gVar.size()) {
            StringBuilder sbM = l0.e.m(size, "Ran off end of other: 0, ", ", ");
            sbM.append(gVar.size());
            throw new IllegalArgumentException(sbM.toString());
        }
        byte[] bArr = gVar.f706w;
        int iF = f() + size;
        int iF2 = f();
        int iF3 = gVar.f();
        while (iF2 < iF) {
            if (this.f706w[iF2] != bArr[iF3]) {
                return false;
            }
            iF2++;
            iF3++;
        }
        return true;
    }

    public int f() {
        return 0;
    }

    public byte g(int i) {
        return this.f706w[i];
    }

    public final int hashCode() {
        int i = this.f705v;
        if (i != 0) {
            return i;
        }
        int size = size();
        int iF = f();
        int i10 = size;
        for (int i11 = iF; i11 < iF + size; i11++) {
            i10 = (i10 * 31) + this.f706w[i11];
        }
        if (i10 == 0) {
            i10 = 1;
        }
        this.f705v = i10;
        return i10;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new d(this);
    }

    public int size() {
        return this.f706w.length;
    }

    public final String toString() {
        String string;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            string = w8.e.g(this);
        } else {
            StringBuilder sb = new StringBuilder();
            int iB = b(0, 47, size());
            sb.append(w8.e.g(iB == 0 ? f703x : new f(this.f706w, f(), iB)));
            sb.append("...");
            string = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder("<ByteString@");
        sb2.append(hexString);
        sb2.append(" size=");
        sb2.append(size);
        sb2.append(" contents=\"");
        return q4.a.q(sb2, string, "\">");
    }
}
