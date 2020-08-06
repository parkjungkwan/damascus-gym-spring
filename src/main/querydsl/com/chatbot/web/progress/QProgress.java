package com.chatbot.web.progress;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProgress is a Querydsl query type for Progress
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProgress extends EntityPathBase<Progress> {

    private static final long serialVersionUID = -287866904L;

    public static final QProgress progress = new QProgress("progress");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath progressTitle = createString("progressTitle");

    public QProgress(String variable) {
        super(Progress.class, forVariable(variable));
    }

    public QProgress(Path<? extends Progress> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProgress(PathMetadata metadata) {
        super(Progress.class, metadata);
    }

}

