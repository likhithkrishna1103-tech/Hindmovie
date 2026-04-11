package f9;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t0 implements Runnable {
    public final Object A;
    public final Object B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4409v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f4410w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f4411x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f4412y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Object f4413z;

    public t0(w0 w0Var, int i, String str, Object obj, Object obj2, Object obj3) {
        this.f4410w = i;
        this.f4411x = str;
        this.f4412y = obj;
        this.f4413z = obj2;
        this.A = obj3;
        this.B = w0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4409v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                w0 w0Var = (w0) this.B;
                f1 f1Var = ((r1) w0Var.f307w).f4367z;
                r1.e(f1Var);
                if (!f1Var.f4048x) {
                    Log.println(6, w0Var.w1(), "Persisted config not initialized. Not logging error/warn");
                    return;
                }
                if (w0Var.f4454y == 0) {
                    g gVar = ((r1) w0Var.f307w).f4366y;
                    if (gVar.A == null) {
                        synchronized (gVar) {
                            try {
                                if (gVar.A == null) {
                                    r1 r1Var = (r1) gVar.f307w;
                                    ApplicationInfo applicationInfo = r1Var.f4363v.getApplicationInfo();
                                    String strB = s8.b.b();
                                    if (applicationInfo != null) {
                                        String str = applicationInfo.processName;
                                        gVar.A = Boolean.valueOf(str != null && str.equals(strB));
                                    }
                                    if (gVar.A == null) {
                                        gVar.A = Boolean.TRUE;
                                        w0 w0Var2 = r1Var.A;
                                        r1.g(w0Var2);
                                        w0Var2.B.a("My process not in the list of running processes");
                                    }
                                }
                            } finally {
                            }
                        }
                    }
                    if (gVar.A.booleanValue()) {
                        w0Var.f4454y = 'C';
                    } else {
                        w0Var.f4454y = 'c';
                    }
                    break;
                }
                if (w0Var.f4455z < 0) {
                    ((r1) w0Var.f307w).f4366y.r1();
                    w0Var.f4455z = 133005L;
                }
                int i = this.f4410w;
                char c9 = w0Var.f4454y;
                long j4 = w0Var.f4455z;
                String str2 = this.f4411x;
                Object obj = this.f4412y;
                Object obj2 = this.f4413z;
                Object obj3 = this.A;
                char cCharAt = "01VDIWEA?".charAt(i);
                String strX1 = w0.x1(true, str2, obj, obj2, obj3);
                StringBuilder sb = new StringBuilder(String.valueOf(cCharAt).length() + 1 + String.valueOf(c9).length() + String.valueOf(j4).length() + 1 + strX1.length());
                sb.append("2");
                sb.append(cCharAt);
                sb.append(c9);
                sb.append(j4);
                sb.append(":");
                sb.append(strX1);
                String string = sb.toString();
                if (string.length() > 1024) {
                    string = str2.substring(0, 1024);
                }
                b7.d dVar = f1Var.A;
                if (dVar != null) {
                    String str3 = (String) dVar.f1828y;
                    f1 f1Var2 = (f1) dVar.f1829z;
                    f1Var2.m1();
                    if (((f1) dVar.f1829z).q1().getLong((String) dVar.f1826w, 0L) == 0) {
                        dVar.y();
                    }
                    if (string == null) {
                        string = "";
                    }
                    SharedPreferences sharedPreferencesQ1 = f1Var2.q1();
                    String str4 = (String) dVar.f1827x;
                    long j7 = sharedPreferencesQ1.getLong(str4, 0L);
                    if (j7 <= 0) {
                        SharedPreferences.Editor editorEdit = f1Var2.q1().edit();
                        editorEdit.putString(str3, string);
                        editorEdit.putLong(str4, 1L);
                        editorEdit.apply();
                        return;
                    }
                    u4 u4Var = ((r1) f1Var2.f307w).D;
                    r1.e(u4Var);
                    long jNextLong = u4Var.k2().nextLong() & Long.MAX_VALUE;
                    long j10 = j7 + 1;
                    long j11 = Long.MAX_VALUE / j10;
                    SharedPreferences.Editor editorEdit2 = f1Var2.q1().edit();
                    if (jNextLong < j11) {
                        editorEdit2.putString(str3, string);
                    }
                    editorEdit2.putLong(str4, j10);
                    editorEdit2.apply();
                    return;
                }
                return;
            default:
                ((y0) this.f4412y).l(this.f4411x, this.f4410w, (Throwable) this.f4413z, (byte[]) this.A, (Map) this.B);
                return;
        }
    }

    public /* synthetic */ t0(String str, y0 y0Var, int i, IOException iOException, byte[] bArr, Map map) {
        o8.u.g(y0Var);
        this.f4412y = y0Var;
        this.f4410w = i;
        this.f4413z = iOException;
        this.A = bArr;
        this.f4411x = str;
        this.B = map;
    }
}
