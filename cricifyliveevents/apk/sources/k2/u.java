package k2;

import android.content.Context;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6897a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6899c;

    public /* synthetic */ u() {
    }

    public boolean equals(Object obj) {
        switch (this.f6897a) {
            case 2:
                if (!(obj instanceof s0.b)) {
                    return false;
                }
                if (this.f6898b != null) {
                    throw null;
                }
                if (this.f6899c == null) {
                    return true;
                }
                throw null;
            default:
                return super.equals(obj);
        }
    }

    public int hashCode() {
        switch (this.f6897a) {
            case 2:
                String str = this.f6898b;
                int iHashCode = str == null ? 0 : str.hashCode();
                String str2 = this.f6899c;
                return iHashCode ^ (str2 != null ? str2.hashCode() : 0);
            default:
                return super.hashCode();
        }
    }

    public String toString() {
        switch (this.f6897a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return this.f6898b + ", " + this.f6899c;
            case 1:
            default:
                return super.toString();
            case 2:
                return "Pair{" + ((Object) this.f6898b) + " " + ((Object) this.f6899c) + "}";
        }
    }

    public u(String str, String str2) {
        this.f6898b = str;
        this.f6899c = str2;
    }

    public u(i2.k kVar) {
        Context context = (Context) kVar.f6085v;
        int iD = nb.f.d(context, "com.google.firebase.crashlytics.unity_version", "string");
        if (iD != 0) {
            this.f6898b = "Unity";
            String string = context.getResources().getString(iD);
            this.f6899c = string;
            String strN = q4.a.n("Unity Editor version is: ", string);
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", strN, null);
                return;
            }
            return;
        }
        if (context.getAssets() != null) {
            try {
                InputStream inputStreamOpen = context.getAssets().open("flutter_assets/NOTICES.Z");
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                this.f6898b = "Flutter";
                this.f6899c = null;
                if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                    Log.v("FirebaseCrashlytics", "Development platform is: Flutter", null);
                    return;
                }
                return;
            } catch (IOException unused) {
            }
        }
        this.f6898b = null;
        this.f6899c = null;
    }
}
