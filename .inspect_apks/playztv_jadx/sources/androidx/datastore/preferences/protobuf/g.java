package androidx.datastore.preferences.protobuf;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class g implements Iterable, Serializable {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final g f1043w = new g(z.f1148b);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final f f1044x;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1045u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final byte[] f1046v;

    static {
        f1044x = c.a() ? new f(1) : new f(0);
    }

    public g(byte[] bArr) {
        bArr.getClass();
        this.f1046v = bArr;
    }

    public static g b(byte[] bArr, int i, int i10) {
        byte[] bArrCopyOfRange;
        int i11 = i + i10;
        int length = bArr.length;
        if (((i11 - i) | i | i11 | (length - i11)) < 0) {
            if (i < 0) {
                throw new IndexOutOfBoundsException(e6.j.j(i, "Beginning index: ", " < 0"));
            }
            if (i11 < i) {
                throw new IndexOutOfBoundsException(l4.a.l(i, i11, "Beginning index larger than ending index: ", ", "));
            }
            throw new IndexOutOfBoundsException(l4.a.l(i11, length, "End index: ", " >= "));
        }
        switch (f1044x.f1041a) {
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

    public int d() {
        return 0;
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
        int i = this.f1045u;
        int i10 = gVar.f1045u;
        if (i != 0 && i10 != 0 && i != i10) {
            return false;
        }
        int size = size();
        if (size > gVar.size()) {
            throw new IllegalArgumentException("Length too large: " + size + size());
        }
        if (size > gVar.size()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + size + ", " + gVar.size());
        }
        byte[] bArr = gVar.f1046v;
        int iD = d() + size;
        int iD2 = d();
        int iD3 = gVar.d();
        while (iD2 < iD) {
            if (this.f1046v[iD2] != bArr[iD3]) {
                return false;
            }
            iD2++;
            iD3++;
        }
        return true;
    }

    public final int hashCode() {
        int i = this.f1045u;
        if (i != 0) {
            return i;
        }
        int size = size();
        int iD = d();
        int i10 = size;
        for (int i11 = iD; i11 < iD + size; i11++) {
            i10 = (i10 * 31) + this.f1046v[i11];
        }
        if (i10 == 0) {
            i10 = 1;
        }
        this.f1045u = i10;
        return i10;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new e(this);
    }

    public int size() {
        return this.f1046v.length;
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }
}
