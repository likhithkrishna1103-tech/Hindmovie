package g7;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements l, x6.f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ByteBuffer f5192v;

    public j() {
        this.f5192v = ByteBuffer.allocate(4);
    }

    @Override // x6.f
    public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        Integer num = (Integer) obj;
        if (num == null) {
            return;
        }
        messageDigest.update(bArr);
        synchronized (this.f5192v) {
            this.f5192v.position(0);
            messageDigest.update(this.f5192v.putInt(num.intValue()).array());
        }
    }

    @Override // g7.l
    public short o() throws k {
        ByteBuffer byteBuffer = this.f5192v;
        if (byteBuffer.remaining() >= 1) {
            return (short) (byteBuffer.get() & 255);
        }
        throw new k();
    }

    @Override // g7.l
    public long skip(long j4) {
        ByteBuffer byteBuffer = this.f5192v;
        int iMin = (int) Math.min(byteBuffer.remaining(), j4);
        byteBuffer.position(byteBuffer.position() + iMin);
        return iMin;
    }

    @Override // g7.l
    public int v() {
        return (o() << 8) | o();
    }

    @Override // g7.l
    public int z(int i, byte[] bArr) {
        ByteBuffer byteBuffer = this.f5192v;
        int iMin = Math.min(i, byteBuffer.remaining());
        if (iMin == 0) {
            return -1;
        }
        byteBuffer.get(bArr, 0, iMin);
        return iMin;
    }

    public j(ByteBuffer byteBuffer) {
        this.f5192v = byteBuffer;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }
}
