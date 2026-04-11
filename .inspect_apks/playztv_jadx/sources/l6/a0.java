package l6;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements c6.g, com.bumptech.glide.load.data.g {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ByteBuffer f7956u;

    public a0(ByteBuffer byteBuffer) {
        this.f7956u = byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.g
    public Object a() {
        ByteBuffer byteBuffer = this.f7956u;
        byteBuffer.position(0);
        return byteBuffer;
    }

    @Override // c6.g
    public void f(byte[] bArr, Object obj, MessageDigest messageDigest) {
        Integer num = (Integer) obj;
        if (num == null) {
            return;
        }
        messageDigest.update(bArr);
        synchronized (this.f7956u) {
            this.f7956u.position(0);
            messageDigest.update(this.f7956u.putInt(num.intValue()).array());
        }
    }

    public a0() {
        this.f7956u = ByteBuffer.allocate(4);
    }

    @Override // com.bumptech.glide.load.data.g
    public void b() {
    }
}
