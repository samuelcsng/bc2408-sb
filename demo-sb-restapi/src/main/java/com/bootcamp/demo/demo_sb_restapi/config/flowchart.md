<!-- - (build) List<UserEntity> userEntities 
  - <- collect (build) userEntity
      - <- userEntity.set(name, username, email, phone, website, postEntities)
      - // <- (build) postEntities <- collect (build) List<PostEntity> postEntities <- collect (build) postEntity

      // postEntity.set(title, body)
          // build List<CommentEntity>
          // build CommentEntity -> collect -->



[]userEntities =
List<UserEntity> [userEntity...]
userEntity ($name, $username, $email, $phone, $website, $[]postEntities)

[]postEntities =
List<PostEntity> [postEntity...]
postEntity (.set$User(userEntity), $title, $body, $[]commentEntities)

[]commentEntities =
List<CommentEntity> [commentEntity...]
commentEntity (.set$Post(postEntity), $name, $email, $body)