package fb;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import f9.h2;
import f9.i2;
import i2.k;
import java.util.HashSet;
import l4.c0;
import p6.c;
import ua.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4534b;

    public /* synthetic */ b(int i, Object obj) {
        this.f4533a = i;
        this.f4534b = obj;
    }

    @Override // f9.i2
    public final void a(long j4, Bundle bundle, String str, String str2) {
        int i = this.f4533a;
        Object obj = this.f4534b;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                c0 c0Var = (c0) obj;
                if (((HashSet) c0Var.f7705w).contains(str2)) {
                    Bundle bundle2 = new Bundle();
                    m0 m0Var = a.f4528a;
                    String strG = h2.g(str2, h2.f4206c, h2.f4204a);
                    if (strG != null) {
                        str2 = strG;
                    }
                    bundle2.putString("events", str2);
                    ((k) c0Var.f7706x).o(2, bundle2);
                    break;
                }
                break;
            default:
                if (str != null && !a.f4528a.contains(str2)) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("name", str2);
                    bundle3.putLong("timestampInMillis", j4);
                    bundle3.putBundle("params", bundle);
                    ((k) ((c) obj).f10035w).o(3, bundle3);
                    break;
                }
                break;
        }
    }
}
