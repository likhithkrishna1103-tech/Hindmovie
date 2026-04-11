package s2;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends IOException {
    public g(int i) {
        this(i, -9223372036854775807L, -9223372036854775807L);
    }

    public g(int i, long j4, long j7) {
        String str;
        StringBuilder sb = new StringBuilder("Illegal clipping: ");
        if (i != 0) {
            if (i == 1) {
                str = "not seekable to start";
            } else if (i != 2) {
                str = "unknown";
            } else {
                y1.d.g((j4 == -9223372036854775807L || j7 == -9223372036854775807L) ? false : true);
                str = "start exceeds end. Start time: " + j4 + ", End time: " + j7;
            }
        } else {
            str = "invalid period count";
        }
        sb.append(str);
        super(sb.toString());
    }
}
