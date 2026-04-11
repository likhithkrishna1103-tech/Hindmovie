package i2;

import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class q extends Exception {
    public q(Status status) {
        int i = status.f2306v;
        String str = status.f2307w;
        str = str == null ? "" : str;
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 2 + str.length());
        sb.append(i);
        sb.append(": ");
        sb.append(str);
        super(sb.toString());
    }
}
