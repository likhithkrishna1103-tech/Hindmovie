package n1;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class b extends InputStream implements DataInput {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final DataInputStream f8593v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ByteOrder f8594w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f8595x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public byte[] f8596y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ByteOrder f8592z = ByteOrder.LITTLE_ENDIAN;
    public static final ByteOrder A = ByteOrder.BIG_ENDIAN;

    public b(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        this(byteArrayInputStream, 0);
    }

    public final void a(int i) throws IOException {
        int i10 = 0;
        while (i10 < i) {
            int i11 = i - i10;
            DataInputStream dataInputStream = this.f8593v;
            int iSkip = (int) dataInputStream.skip(i11);
            if (iSkip <= 0) {
                if (this.f8596y == null) {
                    this.f8596y = new byte[8192];
                }
                iSkip = dataInputStream.read(this.f8596y, 0, Math.min(8192, i11));
                if (iSkip == -1) {
                    throw new EOFException(l0.e.h(i, "Reached EOF while skipping ", " bytes."));
                }
            }
            i10 += iSkip;
        }
        this.f8595x += i10;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f8593v.available();
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        throw new UnsupportedOperationException("Mark is currently unsupported");
    }

    @Override // java.io.InputStream
    public final int read() {
        this.f8595x++;
        return this.f8593v.read();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        this.f8595x++;
        return this.f8593v.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() throws IOException {
        this.f8595x++;
        int i = this.f8593v.read();
        if (i >= 0) {
            return (byte) i;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        this.f8595x += 2;
        return this.f8593v.readChar();
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
        this.f8595x += i10;
        this.f8593v.readFully(bArr, i, i10);
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        this.f8595x += 4;
        DataInputStream dataInputStream = this.f8593v;
        int i = dataInputStream.read();
        int i10 = dataInputStream.read();
        int i11 = dataInputStream.read();
        int i12 = dataInputStream.read();
        if ((i | i10 | i11 | i12) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f8594w;
        if (byteOrder == f8592z) {
            return (i12 << 24) + (i11 << 16) + (i10 << 8) + i;
        }
        if (byteOrder == A) {
            return (i << 24) + (i10 << 16) + (i11 << 8) + i12;
        }
        throw new IOException("Invalid byte order: " + this.f8594w);
    }

    @Override // java.io.DataInput
    public final String readLine() {
        Log.d("ExifInterface", "Currently unsupported");
        return null;
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        long j4;
        long j7;
        this.f8595x += 8;
        DataInputStream dataInputStream = this.f8593v;
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
        ByteOrder byteOrder = this.f8594w;
        if (byteOrder == f8592z) {
            j4 = (((long) i16) << 56) + (((long) i15) << 48) + (((long) i14) << 40) + (((long) i13) << 32) + (((long) i12) << 24) + (((long) i11) << 16) + (((long) i10) << 8);
            j7 = i;
        } else {
            if (byteOrder != A) {
                throw new IOException("Invalid byte order: " + this.f8594w);
            }
            j4 = (((long) i) << 56) + (((long) i10) << 48) + (((long) i11) << 40) + (((long) i12) << 32) + (((long) i13) << 24) + (((long) i14) << 16) + (((long) i15) << 8);
            j7 = i16;
        }
        return j4 + j7;
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        this.f8595x += 2;
        DataInputStream dataInputStream = this.f8593v;
        int i = dataInputStream.read();
        int i10 = dataInputStream.read();
        if ((i | i10) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f8594w;
        if (byteOrder == f8592z) {
            return (short) ((i10 << 8) + i);
        }
        if (byteOrder == A) {
            return (short) ((i << 8) + i10);
        }
        throw new IOException("Invalid byte order: " + this.f8594w);
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        this.f8595x += 2;
        return this.f8593v.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        this.f8595x++;
        return this.f8593v.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        this.f8595x += 2;
        DataInputStream dataInputStream = this.f8593v;
        int i = dataInputStream.read();
        int i10 = dataInputStream.read();
        if ((i | i10) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f8594w;
        if (byteOrder == f8592z) {
            return (i10 << 8) + i;
        }
        if (byteOrder == A) {
            return (i << 8) + i10;
        }
        throw new IOException("Invalid byte order: " + this.f8594w);
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
        this.f8594w = byteOrder;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f8593v = dataInputStream;
        dataInputStream.mark(0);
        this.f8595x = 0;
        this.f8594w = byteOrder;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i10) throws IOException {
        int i11 = this.f8593v.read(bArr, i, i10);
        this.f8595x += i11;
        return i11;
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) throws IOException {
        this.f8595x += bArr.length;
        this.f8593v.readFully(bArr);
    }
}
