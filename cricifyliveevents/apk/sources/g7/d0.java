package g7;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements x6.f, com.bumptech.glide.load.data.f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ByteBuffer f5178v;

    public d0(ByteBuffer byteBuffer) {
        this.f5178v = byteBuffer;
    }

    @Override // x6.f
    public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        Long l10 = (Long) obj;
        messageDigest.update(bArr);
        synchronized (this.f5178v) {
            this.f5178v.position(0);
            messageDigest.update(this.f5178v.putLong(l10.longValue()).array());
        }
    }

    @Override // com.bumptech.glide.load.data.f
    public Object c() {
        ByteBuffer byteBuffer = this.f5178v;
        byteBuffer.position(0);
        return byteBuffer;
    }

    public d0() {
        this.f5178v = ByteBuffer.allocate(8);
    }

    @Override // com.bumptech.glide.load.data.f
    public void b() {
    }
}
