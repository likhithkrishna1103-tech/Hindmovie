package t4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f11923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f11924d;

    public e(int i, int i10, long j4, long j7) {
        this.f11921a = i;
        this.f11922b = i10;
        this.f11923c = j4;
        this.f11924d = j7;
    }

    public static e a(File file) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            e eVar = new e(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
            dataInputStream.close();
            return eVar;
        } finally {
        }
    }

    public final void b(File file) throws IOException {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f11921a);
            dataOutputStream.writeInt(this.f11922b);
            dataOutputStream.writeLong(this.f11923c);
            dataOutputStream.writeLong(this.f11924d);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof e)) {
            e eVar = (e) obj;
            if (this.f11922b == eVar.f11922b && this.f11923c == eVar.f11923c && this.f11921a == eVar.f11921a && this.f11924d == eVar.f11924d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f11922b), Long.valueOf(this.f11923c), Integer.valueOf(this.f11921a), Long.valueOf(this.f11924d));
    }
}
