package o4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f9361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f9362d;

    public h(int i, int i10, long j5, long j8) {
        this.f9359a = i;
        this.f9360b = i10;
        this.f9361c = j5;
        this.f9362d = j8;
    }

    public static h a(File file) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            h hVar = new h(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
            dataInputStream.close();
            return hVar;
        } finally {
        }
    }

    public final void b(File file) throws IOException {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f9359a);
            dataOutputStream.writeInt(this.f9360b);
            dataOutputStream.writeLong(this.f9361c);
            dataOutputStream.writeLong(this.f9362d);
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
        if (obj != null && (obj instanceof h)) {
            h hVar = (h) obj;
            if (this.f9360b == hVar.f9360b && this.f9361c == hVar.f9361c && this.f9359a == hVar.f9359a && this.f9362d == hVar.f9362d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f9360b), Long.valueOf(this.f9361c), Integer.valueOf(this.f9359a), Long.valueOf(this.f9362d));
    }
}
