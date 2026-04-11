package va;

import e6.f0;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements Closeable {
    public static final Logger A = Logger.getLogger(l.class.getName());

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RandomAccessFile f13452u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13453v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f13454w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public i f13455x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public i f13456y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final byte[] f13457z;

    public l(File file) throws IOException {
        byte[] bArr = new byte[16];
        this.f13457z = bArr;
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
                    j0(bArr2, i, iArr[i10]);
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
        this.f13452u = randomAccessFile2;
        randomAccessFile2.seek(0L);
        randomAccessFile2.readFully(bArr);
        int iH = H(0, bArr);
        this.f13453v = iH;
        if (iH > randomAccessFile2.length()) {
            throw new IOException("File is truncated. Expected length: " + this.f13453v + ", Actual length: " + randomAccessFile2.length());
        }
        this.f13454w = H(4, bArr);
        int iH2 = H(8, bArr);
        int iH3 = H(12, bArr);
        this.f13455x = G(iH2);
        this.f13456y = G(iH3);
    }

    public static int H(int i, byte[] bArr) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    public static void j0(byte[] bArr, int i, int i10) {
        bArr[i] = (byte) (i10 >> 24);
        bArr[i + 1] = (byte) (i10 >> 16);
        bArr[i + 2] = (byte) (i10 >> 8);
        bArr[i + 3] = (byte) i10;
    }

    public final synchronized boolean F() {
        return this.f13454w == 0;
    }

    public final i G(int i) throws IOException {
        if (i == 0) {
            return i.f13446c;
        }
        RandomAccessFile randomAccessFile = this.f13452u;
        randomAccessFile.seek(i);
        return new i(i, randomAccessFile.readInt());
    }

    public final synchronized void J() {
        try {
            if (F()) {
                throw new NoSuchElementException();
            }
            if (this.f13454w == 1) {
                d();
            } else {
                i iVar = this.f13455x;
                int iH0 = h0(iVar.f13447a + 4 + iVar.f13448b);
                K(iH0, 0, 4, this.f13457z);
                int iH = H(0, this.f13457z);
                i0(this.f13453v, this.f13454w - 1, iH0, this.f13456y.f13447a);
                this.f13454w--;
                this.f13455x = new i(iH0, iH);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void K(int i, int i10, int i11, byte[] bArr) throws IOException {
        int iH0 = h0(i);
        int i12 = iH0 + i11;
        int i13 = this.f13453v;
        RandomAccessFile randomAccessFile = this.f13452u;
        if (i12 <= i13) {
            randomAccessFile.seek(iH0);
            randomAccessFile.readFully(bArr, i10, i11);
            return;
        }
        int i14 = i13 - iH0;
        randomAccessFile.seek(iH0);
        randomAccessFile.readFully(bArr, i10, i14);
        randomAccessFile.seek(16L);
        randomAccessFile.readFully(bArr, i10 + i14, i11 - i14);
    }

    public final void S(byte[] bArr, int i, int i10) throws IOException {
        int iH0 = h0(i);
        int i11 = iH0 + i10;
        int i12 = this.f13453v;
        RandomAccessFile randomAccessFile = this.f13452u;
        if (i11 <= i12) {
            randomAccessFile.seek(iH0);
            randomAccessFile.write(bArr, 0, i10);
            return;
        }
        int i13 = i12 - iH0;
        randomAccessFile.seek(iH0);
        randomAccessFile.write(bArr, 0, i13);
        randomAccessFile.seek(16L);
        randomAccessFile.write(bArr, i13, i10 - i13);
    }

    public final void a(byte[] bArr) {
        int iH0;
        int length = bArr.length;
        synchronized (this) {
            if (length >= 0) {
                if (length <= bArr.length) {
                    v(length);
                    boolean zF = F();
                    if (zF) {
                        iH0 = 16;
                    } else {
                        i iVar = this.f13456y;
                        iH0 = h0(iVar.f13447a + 4 + iVar.f13448b);
                    }
                    i iVar2 = new i(iH0, length);
                    j0(this.f13457z, 0, length);
                    S(this.f13457z, iH0, 4);
                    S(bArr, iH0 + 4, length);
                    i0(this.f13453v, this.f13454w + 1, zF ? iH0 : this.f13455x.f13447a, iH0);
                    this.f13456y = iVar2;
                    this.f13454w++;
                    if (zF) {
                        this.f13455x = iVar2;
                    }
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f13452u.close();
    }

    public final synchronized void d() {
        i0(4096, 0, 0, 0);
        this.f13454w = 0;
        i iVar = i.f13446c;
        this.f13455x = iVar;
        this.f13456y = iVar;
        if (this.f13453v > 4096) {
            RandomAccessFile randomAccessFile = this.f13452u;
            randomAccessFile.setLength(4096);
            randomAccessFile.getChannel().force(true);
        }
        this.f13453v = 4096;
    }

    public final int g0() {
        if (this.f13454w == 0) {
            return 16;
        }
        i iVar = this.f13456y;
        int i = iVar.f13447a;
        int i10 = this.f13455x.f13447a;
        return i >= i10 ? (i - i10) + 4 + iVar.f13448b + 16 : (((i + 4) + iVar.f13448b) + this.f13453v) - i10;
    }

    public final int h0(int i) {
        int i10 = this.f13453v;
        return i < i10 ? i : (i + 16) - i10;
    }

    public final void i0(int i, int i10, int i11, int i12) throws IOException {
        int[] iArr = {i, i10, i11, i12};
        int i13 = 0;
        int i14 = 0;
        while (true) {
            byte[] bArr = this.f13457z;
            if (i13 >= 4) {
                RandomAccessFile randomAccessFile = this.f13452u;
                randomAccessFile.seek(0L);
                randomAccessFile.write(bArr);
                return;
            } else {
                j0(bArr, i14, iArr[i13]);
                i14 += 4;
                i13++;
            }
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(l.class.getSimpleName());
        sb2.append("[fileLength=");
        sb2.append(this.f13453v);
        sb2.append(", size=");
        sb2.append(this.f13454w);
        sb2.append(", first=");
        sb2.append(this.f13455x);
        sb2.append(", last=");
        sb2.append(this.f13456y);
        sb2.append(", element lengths=[");
        try {
            f0 f0Var = new f0();
            f0Var.f4499v = sb2;
            f0Var.f4498u = true;
            x(f0Var);
        } catch (IOException e10) {
            A.log(Level.WARNING, "read error", (Throwable) e10);
        }
        sb2.append("]]");
        return sb2.toString();
    }

    public final void v(int i) throws IOException {
        int i10 = i + 4;
        int iG0 = this.f13453v - g0();
        if (iG0 >= i10) {
            return;
        }
        int i11 = this.f13453v;
        do {
            iG0 += i11;
            i11 <<= 1;
        } while (iG0 < i10);
        RandomAccessFile randomAccessFile = this.f13452u;
        randomAccessFile.setLength(i11);
        randomAccessFile.getChannel().force(true);
        i iVar = this.f13456y;
        int iH0 = h0(iVar.f13447a + 4 + iVar.f13448b);
        if (iH0 < this.f13455x.f13447a) {
            FileChannel channel = randomAccessFile.getChannel();
            channel.position(this.f13453v);
            long j5 = iH0 - 4;
            if (channel.transferTo(16L, j5, channel) != j5) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i12 = this.f13456y.f13447a;
        int i13 = this.f13455x.f13447a;
        if (i12 < i13) {
            int i14 = (this.f13453v + i12) - 16;
            i0(i11, this.f13454w, i13, i14);
            this.f13456y = new i(i14, this.f13456y.f13448b);
        } else {
            i0(i11, this.f13454w, i13, i12);
        }
        this.f13453v = i11;
    }

    public final synchronized void x(k kVar) {
        int iH0 = this.f13455x.f13447a;
        for (int i = 0; i < this.f13454w; i++) {
            i iVarG = G(iH0);
            kVar.a(new j(this, iVarG), iVarG.f13448b);
            iH0 = h0(iVarG.f13447a + 4 + iVarG.f13448b);
        }
    }
}
