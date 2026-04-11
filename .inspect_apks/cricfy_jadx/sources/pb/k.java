package pb;

import com.google.android.gms.internal.measurement.o4;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Closeable {
    public static final Logger B = Logger.getLogger(k.class.getName());
    public final byte[] A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RandomAccessFile f10166v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10167w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f10168x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public h f10169y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public h f10170z;

    public k(File file) throws IOException {
        byte[] bArr = new byte[16];
        this.A = bArr;
        if (!file.exists()) {
            File file2 = new File(file.getPath() + ".tmp");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rwd");
            try {
                randomAccessFile.setLength(4096L);
                randomAccessFile.seek(0L);
                byte[] bArr2 = new byte[16];
                int[] iArr = {4096, 0, 0, 0};
                int i = 0;
                for (int i10 = 0; i10 < 4; i10++) {
                    h0(bArr2, i, iArr[i10]);
                    i += 4;
                }
                randomAccessFile.write(bArr2);
                randomAccessFile.close();
                if (!file2.renameTo(file)) {
                    throw new IOException("Rename failed!");
                }
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        }
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
        this.f10166v = randomAccessFile2;
        randomAccessFile2.seek(0L);
        randomAccessFile2.readFully(bArr);
        int iC = C(0, bArr);
        this.f10167w = iC;
        if (iC > randomAccessFile2.length()) {
            throw new IOException("File is truncated. Expected length: " + this.f10167w + ", Actual length: " + randomAccessFile2.length());
        }
        this.f10168x = C(4, bArr);
        int iC2 = C(8, bArr);
        int iC3 = C(12, bArr);
        this.f10169y = A(iC2);
        this.f10170z = A(iC3);
    }

    public static int C(int i, byte[] bArr) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    public static void h0(byte[] bArr, int i, int i10) {
        bArr[i] = (byte) (i10 >> 24);
        bArr[i + 1] = (byte) (i10 >> 16);
        bArr[i + 2] = (byte) (i10 >> 8);
        bArr[i + 3] = (byte) i10;
    }

    public final h A(int i) throws IOException {
        if (i == 0) {
            return h.f10160c;
        }
        RandomAccessFile randomAccessFile = this.f10166v;
        randomAccessFile.seek(i);
        return new h(i, randomAccessFile.readInt());
    }

    public final synchronized void J() {
        try {
            if (z()) {
                throw new NoSuchElementException();
            }
            if (this.f10168x == 1) {
                g();
            } else {
                h hVar = this.f10169y;
                int iE0 = e0(hVar.f10161a + 4 + hVar.f10162b);
                O(iE0, 0, 4, this.A);
                int iC = C(0, this.A);
                g0(this.f10167w, this.f10168x - 1, iE0, this.f10170z.f10161a);
                this.f10168x--;
                this.f10169y = new h(iE0, iC);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void O(int i, int i10, int i11, byte[] bArr) throws IOException {
        int iE0 = e0(i);
        int i12 = iE0 + i11;
        int i13 = this.f10167w;
        RandomAccessFile randomAccessFile = this.f10166v;
        if (i12 <= i13) {
            randomAccessFile.seek(iE0);
            randomAccessFile.readFully(bArr, i10, i11);
            return;
        }
        int i14 = i13 - iE0;
        randomAccessFile.seek(iE0);
        randomAccessFile.readFully(bArr, i10, i14);
        randomAccessFile.seek(16L);
        randomAccessFile.readFully(bArr, i10 + i14, i11 - i14);
    }

    public final void Q(byte[] bArr, int i, int i10) throws IOException {
        int iE0 = e0(i);
        int i11 = iE0 + i10;
        int i12 = this.f10167w;
        RandomAccessFile randomAccessFile = this.f10166v;
        if (i11 <= i12) {
            randomAccessFile.seek(iE0);
            randomAccessFile.write(bArr, 0, i10);
            return;
        }
        int i13 = i12 - iE0;
        randomAccessFile.seek(iE0);
        randomAccessFile.write(bArr, 0, i13);
        randomAccessFile.seek(16L);
        randomAccessFile.write(bArr, i13, i10 - i13);
    }

    public final int R() {
        if (this.f10168x == 0) {
            return 16;
        }
        h hVar = this.f10170z;
        int i = hVar.f10161a;
        int i10 = this.f10169y.f10161a;
        return i >= i10 ? (i - i10) + 4 + hVar.f10162b + 16 : (((i + 4) + hVar.f10162b) + this.f10167w) - i10;
    }

    public final void a(byte[] bArr) {
        int iE0;
        int length = bArr.length;
        synchronized (this) {
            if (length >= 0) {
                if (length <= bArr.length) {
                    q(length);
                    boolean z10 = z();
                    if (z10) {
                        iE0 = 16;
                    } else {
                        h hVar = this.f10170z;
                        iE0 = e0(hVar.f10161a + 4 + hVar.f10162b);
                    }
                    h hVar2 = new h(iE0, length);
                    h0(this.A, 0, length);
                    Q(this.A, iE0, 4);
                    Q(bArr, iE0 + 4, length);
                    g0(this.f10167w, this.f10168x + 1, z10 ? iE0 : this.f10169y.f10161a, iE0);
                    this.f10170z = hVar2;
                    this.f10168x++;
                    if (z10) {
                        this.f10169y = hVar2;
                    }
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f10166v.close();
    }

    public final int e0(int i) {
        int i10 = this.f10167w;
        return i < i10 ? i : (i + 16) - i10;
    }

    public final synchronized void g() {
        g0(4096, 0, 0, 0);
        this.f10168x = 0;
        h hVar = h.f10160c;
        this.f10169y = hVar;
        this.f10170z = hVar;
        if (this.f10167w > 4096) {
            RandomAccessFile randomAccessFile = this.f10166v;
            randomAccessFile.setLength(4096);
            randomAccessFile.getChannel().force(true);
        }
        this.f10167w = 4096;
    }

    public final void g0(int i, int i10, int i11, int i12) throws IOException {
        int[] iArr = {i, i10, i11, i12};
        int i13 = 0;
        int i14 = 0;
        while (true) {
            byte[] bArr = this.A;
            if (i13 >= 4) {
                RandomAccessFile randomAccessFile = this.f10166v;
                randomAccessFile.seek(0L);
                randomAccessFile.write(bArr);
                return;
            } else {
                h0(bArr, i14, iArr[i13]);
                i14 += 4;
                i13++;
            }
        }
    }

    public final void q(int i) throws IOException {
        int i10 = i + 4;
        int iR = this.f10167w - R();
        if (iR >= i10) {
            return;
        }
        int i11 = this.f10167w;
        do {
            iR += i11;
            i11 <<= 1;
        } while (iR < i10);
        RandomAccessFile randomAccessFile = this.f10166v;
        randomAccessFile.setLength(i11);
        randomAccessFile.getChannel().force(true);
        h hVar = this.f10170z;
        int iE0 = e0(hVar.f10161a + 4 + hVar.f10162b);
        if (iE0 < this.f10169y.f10161a) {
            FileChannel channel = randomAccessFile.getChannel();
            channel.position(this.f10167w);
            long j4 = iE0 - 4;
            if (channel.transferTo(16L, j4, channel) != j4) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i12 = this.f10170z.f10161a;
        int i13 = this.f10169y.f10161a;
        if (i12 < i13) {
            int i14 = (this.f10167w + i12) - 16;
            g0(i11, this.f10168x, i13, i14);
            this.f10170z = new h(i14, this.f10170z.f10162b);
        } else {
            g0(i11, this.f10168x, i13, i12);
        }
        this.f10167w = i11;
    }

    public final synchronized void s(j jVar) {
        int iE0 = this.f10169y.f10161a;
        for (int i = 0; i < this.f10168x; i++) {
            h hVarA = A(iE0);
            jVar.a(new i(this, hVarA), hVarA.f10162b);
            iE0 = e0(hVarA.f10161a + 4 + hVarA.f10162b);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(k.class.getSimpleName());
        sb.append("[fileLength=");
        sb.append(this.f10167w);
        sb.append(", size=");
        sb.append(this.f10168x);
        sb.append(", first=");
        sb.append(this.f10169y);
        sb.append(", last=");
        sb.append(this.f10170z);
        sb.append(", element lengths=[");
        try {
            s(new o4(sb));
        } catch (IOException e9) {
            B.log(Level.WARNING, "read error", (Throwable) e9);
        }
        sb.append("]]");
        return sb.toString();
    }

    public final synchronized boolean z() {
        return this.f10168x == 0;
    }
}
