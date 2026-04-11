package h1;

import android.util.Log;
import e6.j;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class b extends InputStream implements DataInput {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ByteOrder f5613y = ByteOrder.LITTLE_ENDIAN;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ByteOrder f5614z = ByteOrder.BIG_ENDIAN;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final DataInputStream f5615u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ByteOrder f5616v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f5617w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public byte[] f5618x;

    public b(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        this(byteArrayInputStream, 0);
    }

    public final void a(int i) throws IOException {
        int i10 = 0;
        while (i10 < i) {
            int i11 = i - i10;
            DataInputStream dataInputStream = this.f5615u;
            int iSkip = (int) dataInputStream.skip(i11);
            if (iSkip <= 0) {
                if (this.f5618x == null) {
                    this.f5618x = new byte[8192];
                }
                iSkip = dataInputStream.read(this.f5618x, 0, Math.min(8192, i11));
                if (iSkip == -1) {
                    throw new EOFException(j.j(i, "Reached EOF while skipping ", " bytes."));
                }
            }
            i10 += iSkip;
        }
        this.f5617w += i10;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f5615u.available();
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        throw new UnsupportedOperationException("Mark is currently unsupported");
    }

    @Override // java.io.InputStream
    public final int read() {
        this.f5617w++;
        return this.f5615u.read();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        this.f5617w++;
        return this.f5615u.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() throws IOException {
        this.f5617w++;
        int i = this.f5615u.read();
        if (i >= 0) {
            return (byte) i;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        this.f5617w += 2;
        return this.f5615u.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i10) throws IOException {
        this.f5617w += i10;
        this.f5615u.readFully(bArr, i, i10);
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        this.f5617w += 4;
        DataInputStream dataInputStream = this.f5615u;
        int i = dataInputStream.read();
        int i10 = dataInputStream.read();
        int i11 = dataInputStream.read();
        int i12 = dataInputStream.read();
        if ((i | i10 | i11 | i12) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f5616v;
        if (byteOrder == f5613y) {
            return (i12 << 24) + (i11 << 16) + (i10 << 8) + i;
        }
        if (byteOrder == f5614z) {
            return (i << 24) + (i10 << 16) + (i11 << 8) + i12;
        }
        throw new IOException("Invalid byte order: " + this.f5616v);
    }

    @Override // java.io.DataInput
    public final String readLine() {
        Log.d("ExifInterface", "Currently unsupported");
        return null;
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        long j5;
        long j8;
        this.f5617w += 8;
        DataInputStream dataInputStream = this.f5615u;
        int i = dataInputStream.read();
        int i10 = dataInputStream.read();
        int i11 = dataInputStream.read();
        int i12 = dataInputStream.read();
        int i13 = dataInputStream.read();
        int i14 = dataInputStream.read();
        int i15 = dataInputStream.read();
        int i16 = dataInputStream.read();
        if ((i | i10 | i11 | i12 | i13 | i14 | i15 | i16) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f5616v;
        if (byteOrder == f5613y) {
            j5 = (((long) i16) << 56) + (((long) i15) << 48) + (((long) i14) << 40) + (((long) i13) << 32) + (((long) i12) << 24) + (((long) i11) << 16) + (((long) i10) << 8);
            j8 = i;
        } else {
            if (byteOrder != f5614z) {
                throw new IOException("Invalid byte order: " + this.f5616v);
            }
            j5 = (((long) i) << 56) + (((long) i10) << 48) + (((long) i11) << 40) + (((long) i12) << 32) + (((long) i13) << 24) + (((long) i14) << 16) + (((long) i15) << 8);
            j8 = i16;
        }
        return j5 + j8;
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        this.f5617w += 2;
        DataInputStream dataInputStream = this.f5615u;
        int i = dataInputStream.read();
        int i10 = dataInputStream.read();
        if ((i | i10) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f5616v;
        if (byteOrder == f5613y) {
            return (short) ((i10 << 8) + i);
        }
        if (byteOrder == f5614z) {
            return (short) ((i << 8) + i10);
        }
        throw new IOException("Invalid byte order: " + this.f5616v);
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        this.f5617w += 2;
        return this.f5615u.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        this.f5617w++;
        return this.f5615u.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        this.f5617w += 2;
        DataInputStream dataInputStream = this.f5615u;
        int i = dataInputStream.read();
        int i10 = dataInputStream.read();
        if ((i | i10) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f5616v;
        if (byteOrder == f5613y) {
            return (i10 << 8) + i;
        }
        if (byteOrder == f5614z) {
            return (i << 8) + i10;
        }
        throw new IOException("Invalid byte order: " + this.f5616v);
    }

    @Override // java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException("Reset is currently unsupported");
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) {
        throw new UnsupportedOperationException("skipBytes is currently unsupported");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(InputStream inputStream) {
        this(inputStream, 0);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
    }

    public b(InputStream inputStream, int i) {
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        this.f5616v = byteOrder;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f5615u = dataInputStream;
        dataInputStream.mark(0);
        this.f5617w = 0;
        this.f5616v = byteOrder;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i10) throws IOException {
        int i11 = this.f5615u.read(bArr, i, i10);
        this.f5617w += i11;
        return i11;
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) throws IOException {
        this.f5617w += bArr.length;
        this.f5615u.readFully(bArr);
    }
}
