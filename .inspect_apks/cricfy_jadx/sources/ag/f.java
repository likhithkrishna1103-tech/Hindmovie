package ag;

import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public interface f extends u, WritableByteChannel {
    @Override // ag.u, java.io.Flushable
    void flush();

    f u(h hVar);

    f write(byte[] bArr);

    f writeByte(int i);

    f writeInt(int i);

    f writeShort(int i);
}
