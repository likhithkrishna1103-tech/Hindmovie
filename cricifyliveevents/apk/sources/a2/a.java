package a2;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends IOException {
    public /* synthetic */ a(IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(long j4, long j7, int i, IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat("Pos: " + j4 + ", limit: " + j7 + ", len: " + i), indexOutOfBoundsException);
        Locale locale = Locale.US;
    }

    public a(int i, IOException iOException, String str) {
        super(str + ", status code: " + i, iOException);
    }
}
