package ag;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public interface g extends w, ReadableByteChannel {
    String I(long j4);

    void W(long j4);

    String b0(Charset charset);

    InputStream d0();

    h k(long j4);

    boolean o(long j4);

    int r(m mVar);

    byte readByte();

    int readInt();

    short readShort();

    void skip(long j4);

    e w();
}
