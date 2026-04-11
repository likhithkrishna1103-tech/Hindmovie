package com.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Cricify.kt */
/* JADX INFO: loaded from: /data/data/com.termux/files/home/hindmovie/cricifyliveevents/.inspect/cs3/classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0007B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\b¨\u0006\t"}, d2 = {"Lcom/cncverse/PlaylistParserException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "<init>", "(Ljava/lang/String;)V", "InvalidHeader", "Lcom/cncverse/PlaylistParserException$InvalidHeader;", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class PlaylistParserException extends Exception {
    public /* synthetic */ PlaylistParserException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private PlaylistParserException(String message) {
        super(message);
    }

    /* JADX INFO: compiled from: Cricify.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/cncverse/PlaylistParserException$InvalidHeader;", "Lcom/cncverse/PlaylistParserException;", "<init>", "()V", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class InvalidHeader extends PlaylistParserException {
        public InvalidHeader() {
            super("Invalid file header. Header doesn't start with #EXTM3U", null);
        }
    }
}
