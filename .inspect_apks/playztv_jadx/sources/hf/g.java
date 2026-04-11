package hf;

import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public interface g extends u, WritableByteChannel {
    g Y(String str);

    @Override // hf.u, java.io.Flushable
    void flush();

    g g(i iVar);

    g h(long j5);

    g write(byte[] bArr);

    g writeByte(int i);

    g writeInt(int i);

    g writeShort(int i);
}
