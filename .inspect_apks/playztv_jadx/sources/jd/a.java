package jd;

import be.h;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Socket f6939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataInputStream f6940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DataOutputStream f6941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f6942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f6943e;

    public a() {
        Socket socket = new Socket();
        this.f6939a = socket;
        this.f6942d = new Object();
        if (socket.isConnected() && !socket.isClosed()) {
            this.f6940b = new DataInputStream(socket.getInputStream());
            this.f6941c = new DataOutputStream(socket.getOutputStream());
        }
        if (socket.isClosed()) {
            this.f6943e = true;
        }
    }

    public final void a() {
        DataOutputStream dataOutputStream;
        DataInputStream dataInputStream;
        synchronized (this.f6942d) {
            try {
                if (!this.f6943e) {
                    this.f6943e = true;
                    try {
                        dataInputStream = this.f6940b;
                    } catch (Exception unused) {
                    }
                    if (dataInputStream == null) {
                        h.i("dataInput");
                        throw null;
                    }
                    dataInputStream.close();
                    try {
                        dataOutputStream = this.f6941c;
                    } catch (Exception unused2) {
                    }
                    if (dataOutputStream == null) {
                        h.i("dataOutput");
                        throw null;
                    }
                    dataOutputStream.close();
                    try {
                        this.f6939a.close();
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final DataInputStream b() {
        DataInputStream dataInputStream;
        synchronized (this.f6942d) {
            e();
            f();
            dataInputStream = this.f6940b;
            if (dataInputStream == null) {
                h.i("dataInput");
                throw null;
            }
        }
        return dataInputStream;
    }

    public final e c() {
        e eVar;
        synchronized (this.f6942d) {
            e();
            f();
            DataInputStream dataInputStream = this.f6940b;
            if (dataInputStream == null) {
                h.i("dataInput");
                throw null;
            }
            String utf = dataInputStream.readUTF();
            h.d(utf, "readUTF(...)");
            String lowerCase = utf.toLowerCase(Locale.ROOT);
            h.d(lowerCase, "toLowerCase(...)");
            JSONObject jSONObject = new JSONObject(lowerCase);
            int i = jSONObject.getInt("status");
            int i10 = jSONObject.getInt("type");
            int i11 = jSONObject.getInt("connection");
            long j5 = jSONObject.getLong("date");
            long j8 = jSONObject.getLong("content-length");
            String string = jSONObject.getString("md5");
            String string2 = jSONObject.getString("sessionid");
            h.b(string);
            h.b(string2);
            eVar = new e(i, i10, i11, j5, j8, string, string2);
        }
        return eVar;
    }

    public final void d(c cVar) {
        synchronized (this.f6942d) {
            e();
            f();
            DataOutputStream dataOutputStream = this.f6941c;
            if (dataOutputStream == null) {
                h.i("dataOutput");
                throw null;
            }
            dataOutputStream.writeUTF(cVar.a());
            DataOutputStream dataOutputStream2 = this.f6941c;
            if (dataOutputStream2 == null) {
                h.i("dataOutput");
                throw null;
            }
            dataOutputStream2.flush();
        }
    }

    public final void e() throws Exception {
        if (this.f6943e) {
            throw new Exception("FetchFileResourceTransporter is already closed.");
        }
    }

    public final void f() {
        if (this.f6940b == null) {
            h.i("dataInput");
            throw null;
        }
        if (this.f6941c != null) {
            return;
        }
        h.i("dataOutput");
        throw null;
    }
}
