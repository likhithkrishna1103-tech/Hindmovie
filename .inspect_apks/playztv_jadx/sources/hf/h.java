package hf;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public interface h extends w, ReadableByteChannel {
    f B();

    String M(long j5);

    void X(long j5);

    long c0();

    String d0(Charset charset);

    InputStream f0();

    i m(long j5);

    int o(n nVar);

    boolean q(long j5);

    byte readByte();

    int readInt();

    short readShort();

    void skip(long j5);

    String y();
}
