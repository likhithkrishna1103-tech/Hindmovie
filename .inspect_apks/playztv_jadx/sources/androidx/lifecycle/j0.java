package androidx.lifecycle;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j0 extends be.i implements ae.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f1469v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f1470w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j0(int i, Object obj) {
        super(0);
        this.f1469v = i;
        this.f1470w = obj;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [ae.a, be.i] */
    @Override // ae.a
    public final Object b() {
        switch (this.f1469v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return i0.e((u0) this.f1470w);
            case 1:
                File file = (File) ((b1.b) this.f1470w).b();
                String name = file.getName();
                be.h.d(name, "getName(...)");
                if (ie.e.Z(name, "").equals("preferences_pb")) {
                    return file;
                }
                throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: preferences_pb").toString());
            case 2:
                return new ec.m((z0.f) this.f1470w);
            case 3:
                return (List) this.f1470w;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                try {
                    return (List) ((be.i) this.f1470w).b();
                } catch (SSLPeerUnverifiedException unused) {
                    return od.q.f9570u;
                }
            default:
                File file2 = (File) ((z0.a0) this.f1470w).f14744u.b();
                String absolutePath = file2.getAbsolutePath();
                synchronized (z0.a0.D) {
                    LinkedHashSet linkedHashSet = z0.a0.C;
                    if (linkedHashSet.contains(absolutePath)) {
                        throw new IllegalStateException(("There are multiple DataStores active for the same file: " + file2 + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                    }
                    be.h.d(absolutePath, "it");
                    linkedHashSet.add(absolutePath);
                }
                return file2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public j0(ae.a aVar) {
        super(0);
        this.f1469v = 4;
        this.f1470w = (be.i) aVar;
    }
}
