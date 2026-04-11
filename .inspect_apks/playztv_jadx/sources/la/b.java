package la;

import aa.o0;
import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import h4.z;
import java.util.HashSet;
import k8.c2;
import k8.d2;
import p2.c;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8069b;

    public /* synthetic */ b(int i, Object obj) {
        this.f8068a = i;
        this.f8069b = obj;
    }

    @Override // k8.d2
    public final void a(long j5, Bundle bundle, String str, String str2) {
        int i = this.f8068a;
        Object obj = this.f8069b;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                z zVar = (z) obj;
                if (((HashSet) zVar.f5867v).contains(str2)) {
                    Bundle bundle2 = new Bundle();
                    o0 o0Var = a.f8063a;
                    String strC = c2.c(str2, c2.f7112c, c2.f7110a);
                    if (strC != null) {
                        str2 = strC;
                    }
                    bundle2.putString("events", str2);
                    ((c) zVar.f5868w).r(2, bundle2);
                    break;
                }
                break;
            default:
                if (str != null && !a.f8063a.contains(str2)) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("name", str2);
                    bundle3.putLong("timestampInMillis", j5);
                    bundle3.putBundle("params", bundle);
                    ((c) ((u5.c) obj).f12782v).r(3, bundle3);
                    break;
                }
                break;
        }
    }
}
