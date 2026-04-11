package f9;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4470a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f4472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f4473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f4474e;

    public x0(long j4, Bundle bundle, String str, String str2) {
        this.f4472c = str;
        this.f4473d = str2;
        this.f4474e = bundle;
        this.f4471b = j4;
    }

    public static x0 c(v vVar) {
        String str = vVar.f4441v;
        String str2 = vVar.f4443x;
        return new x0(vVar.f4444y, vVar.f4442w.d(), str, str2);
    }

    public int a(of.o oVar, long j4) {
        TimeZone timeZone = lf.f.f7964a;
        ArrayList arrayList = oVar.f9834p;
        int i = 0;
        while (i < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                String str = "A connection to " + oVar.f9823c.f7452a.f7432h + " was leaked. Did you forget to close a response body?";
                uf.f fVar = uf.f.f12506a;
                uf.f.f12506a.k(((of.l) reference).f9815a, str);
                arrayList.remove(i);
                if (arrayList.isEmpty()) {
                    oVar.f9835q = j4 - this.f4471b;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ff A[PHI: r8 r16 r17
      0x00ff: PHI (r8v6 android.database.Cursor) = (r8v7 android.database.Cursor), (r8v10 android.database.Cursor) binds: [B:61:0x012a, B:46:0x00f8] A[DONT_GENERATE, DONT_INLINE]
      0x00ff: PHI (r16v3 com.google.android.gms.internal.measurement.b3) = (r16v5 com.google.android.gms.internal.measurement.b3), (r16v10 com.google.android.gms.internal.measurement.b3) binds: [B:61:0x012a, B:46:0x00f8] A[DONT_GENERATE, DONT_INLINE]
      0x00ff: PHI (r17v2 long) = (r17v4 long), (r17v7 long) binds: [B:61:0x012a, B:46:0x00f8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.gms.internal.measurement.b3 b(com.google.android.gms.internal.measurement.b3 r21, java.lang.String r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 622
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.x0.b(com.google.android.gms.internal.measurement.b3, java.lang.String):com.google.android.gms.internal.measurement.b3");
    }

    public v d() {
        return new v((String) this.f4472c, new u(new Bundle((Bundle) this.f4474e)), (String) this.f4473d, this.f4471b);
    }

    public String toString() {
        switch (this.f4470a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                String str = (String) this.f4473d;
                String string = ((Bundle) this.f4474e).toString();
                int length = String.valueOf(str).length();
                String str2 = (String) this.f4472c;
                StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(str2).length() + 8 + string.length());
                sb.append("origin=");
                sb.append(str);
                sb.append(",name=");
                sb.append(str2);
                return q4.a.q(sb, ",params=", string);
            default:
                return super.toString();
        }
    }

    public x0(nf.d dVar) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        ge.i.e(dVar, "taskRunner");
        ge.i.e(timeUnit, "timeUnit");
        this.f4471b = timeUnit.toNanos(5L);
        this.f4472c = dVar.d();
        this.f4473d = new nf.b(this, q4.a.q(new StringBuilder(), lf.f.f7965b, " ConnectionPool connection closer"));
        this.f4474e = new ConcurrentLinkedQueue();
    }
}
